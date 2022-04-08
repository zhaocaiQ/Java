package com.example.API.service;

import com.example.API.domain.Member;
import com.example.API.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

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

}
