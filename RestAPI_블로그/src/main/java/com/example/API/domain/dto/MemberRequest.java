package com.example.API.domain.dto;

import lombok.Getter;

@Getter
public class MemberRequest {
    private String email;
    private String password;
}