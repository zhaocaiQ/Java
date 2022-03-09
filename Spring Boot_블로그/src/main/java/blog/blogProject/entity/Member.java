package blog.blogProject.entity;

import blog.blogProject.domain.Role;
import blog.blogProject.dto.MemberDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "user")
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;

    private String nickname;
    @Column(length = 100, name = "password",  nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setNickname(memberDto.getNickname());
        member.setEmail(memberDto.getEmail());
        String password = passwordEncoder.encode(memberDto.getPassword()); //비밀번호 암호화
        member.setPassword(password);
        member.setRole(Role.USER);
        return member;
    }
}
