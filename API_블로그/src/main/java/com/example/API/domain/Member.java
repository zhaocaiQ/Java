package com.example.API.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
@Table(name = "member")
@Entity
public class Member {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String email;
  private String password;
  private String nickname;
  private LocalDateTime created_date;

  @NotNull
  @Enumerated(EnumType.STRING)
  private MemberStatus status;

  @Builder
  public Member(String email, String password, String nickname, LocalDateTime created_date, MemberStatus status) {
    this.email = email;
    this.password = password;
    this.nickname = nickname;
    this.created_date = created_date;
    this.status = status;
  }

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "comment")
    private List<Comment> comments = new ArrayList<>();

}
