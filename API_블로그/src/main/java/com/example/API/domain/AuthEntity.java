package com.example.API.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
@Table(name = "auth")
@Entity
public class AuthEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String refreshToken;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @Builder
  public AuthEntity(String refreshToken, Member member) {
    this.refreshToken = refreshToken;
    this.member = member;
  }
  public void refreshUpdate(String refreshToken) {
    this.refreshToken = refreshToken;
  }
}
