package com.example.API.repository;

import com.example.API.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembersRepository extends JpaRepository<Member,Long> {
    //닉네임으로 회원조회
    Optional<Member> findByEmail(String email);
}
