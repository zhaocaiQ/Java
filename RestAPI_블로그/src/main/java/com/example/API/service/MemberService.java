package com.example.API.service;

import com.example.API.config.TokenUtils;
import com.example.API.domain.Auth;
import com.example.API.domain.Member;
import com.example.API.domain.dto.MemberRequest;
import com.example.API.domain.dto.TokenResponse;
import com.example.API.repository.AuthRepository;
import com.example.API.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;
    private final TokenUtils tokenUtils;
    @Autowired
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 가입
     */
    @Transactional
    public Member join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member;
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembersEmail = memberRepository.findByEmail(member.getEmail());
        List<Member> findMembersNickname = memberRepository.findByNickname(member.getNickname());
        if (!findMembersEmail.isEmpty() || !findMembersNickname.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //회원조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    /**
     * 회원 수정
     */
    @Transactional
    public void update(Long id, String password, String nickname) {
        Member member = memberRepository.findOne(id);
        if (password != null) {
            member.setPassword(password);
        }
        if (nickname != null) {
            member.setNickname(nickname);
        }
    }

    //회원삭제
    @Transactional
    public Member deleteById(Long id) {
        Member member = memberRepository.findOne(id);
        if (member == null) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        } else {
            memberRepository.remove(member);
            return member;
        }
    }

    //회원가입
    @Transactional
    public TokenResponse signUp(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        Member findMember = memberRepository.findOne(member.getId());


        String accessToken = tokenUtils.generateJwtToken(findMember);
        String refreshToken = tokenUtils.saveRefreshToken(findMember);

        authRepository.save(
                Auth.builder().member(findMember).refreshToken(refreshToken).build());

        return TokenResponse.builder().ACCESS_TOKEN(accessToken).REFRESH_TOKEN(refreshToken).build();
    }

    @javax.transaction.Transactional
    public TokenResponse signIn(MemberRequest memberRequest) throws Exception {
        Member member = memberRepository.findOneEmail(memberRequest.getEmail());
        Auth auth =
                authRepository
                        .findByMemberId(member.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Token 이 존재하지 않습니다."));
        if (!passwordEncoder.matches(memberRequest.getPassword(), member.getPassword())) {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }
        String accessToken = "";
        String refreshToken = auth.getRefreshToken();

        if (tokenUtils.isValidRefreshToken(refreshToken)) {
            accessToken = tokenUtils.generateJwtToken(auth.getMember());
            return TokenResponse.builder()
                    .ACCESS_TOKEN(accessToken)
                    .REFRESH_TOKEN(auth.getRefreshToken())
                    .build();
        } else {
            accessToken = tokenUtils.generateJwtToken(auth.getMember());
            refreshToken = tokenUtils.saveRefreshToken(member);
            auth.refreshUpdate(refreshToken);
        }

        return TokenResponse.builder().ACCESS_TOKEN(accessToken).REFRESH_TOKEN(refreshToken).build();
    }

}
