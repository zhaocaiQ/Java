package com.example.API.repository;

import com.example.API.domain.Auth;
import com.example.API.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    Optional<Auth> findByMemberId(Long memberId);
}

