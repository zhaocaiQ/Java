package com.example.API.api;


import com.example.API.domain.Member;
import com.example.API.domain.MemberStatus;
import com.example.API.domain.dto.MemberRequest;
import com.example.API.domain.dto.TokenResponse;
import com.example.API.service.MemberService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;


    //DTO로 파라미터를 받아 회원등록 API 생성
//    @PostMapping("/api/members")
//    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
//        Member member = new Member();
//        BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
//        member.setEmail(request.getEmail());
//        member.setPassword(scpwd.encode(request.getPassword()));
////        member.setPassword(request.getPassword());
//        member.setNickname(request.getNickname());
//        member.setCreated_date(LocalDateTime.now());
//        member.setStatus(MemberStatus.USER);
//        Member memberInfo = memberService.join(member);
//        return new CreateMemberResponse(memberInfo.getId());
//    }

    @PostMapping("/api/members")
    public ResponseEntity signUp(@RequestBody CreateMemberRequest request) {
        Member member = new Member();
        BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
        member.setEmail(request.getEmail());
        member.setPassword(scpwd.encode(request.getPassword()));
        member.setNickname(request.getNickname());
        member.setCreated_date(LocalDateTime.now());
        member.setStatus(MemberStatus.USER);

        return ResponseEntity.ok(memberService.signUp(member));
    }

    @Data
    static class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

    //member등록 DTO
    @Data
    static class CreateMemberRequest {
        @NotBlank(message = "이메일은 필수 입력 값입니다.")
        @Email(message = "이메일 형식에 맞지 않습니다.")
        private String email;
        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
                message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
        private String password;
        @NotBlank(message = "닉네임은 필수 입력 값입니다.")
        private String nickname;
    }

    //PUT로 회원수정 API
    @PutMapping("/api/members/{id}")
    public UpdateMemberResponse updateMember(@PathVariable("id") Long id,
                                             @RequestBody @Valid UpdateMemberRequest request) {

        memberService.update(id, request.getPassword(), request.getNickname());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponse(findMember.getId(), findMember.getNickname());
    }

    @Data
    @AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 생성
    static class UpdateMemberResponse {
        private Long id;
        private String nickname;
    }

    @Data
    static class UpdateMemberRequest {
        private String password;
        private String nickname;
    }

    //회원조회
    @GetMapping("/api/members/{id}")
    public MemberDto findMember(@PathVariable("id") Long id) {
        Member member = memberService.findOne(id);
        MemberDto findMember = new MemberDto(member.getId(), member.getEmail(), member.getPassword(), member.getNickname(), member.getCreated_date());
        return findMember;
    }

    //회원전체조회
    @GetMapping("/api/members")
    public Result findMembers() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
                .map(m -> new MemberDto(m.getId(), m.getEmail(), m.getPassword(), m.getNickname(), m.getCreated_date()))
                .collect(Collectors.toList());
        return new Result(collect.size(), collect);
    }

    @Data
    @AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 생성
    static class MemberDto {
        private Long id;
        private String email;
        private String password;
        private String nickname;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDateTime created_date;
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

    //회원삭제
    @DeleteMapping("/api/members/{id}")
    public Member deleteMember(@PathVariable("id") Long id) {
        return memberService.deleteById(id);
    }

    //회원로그인
    @PostMapping("/api/members/signIn")
    public ResponseEntity<TokenResponse> signIn(@RequestBody MemberRequest memberRequest) throws Exception {

        return ResponseEntity.ok().body(memberService.signIn(memberRequest));
    }

    @GetMapping("/info")
    public ResponseEntity<List<Member>> findMember() {
        return ResponseEntity.ok().body(memberService.findMembers());
    }
}
