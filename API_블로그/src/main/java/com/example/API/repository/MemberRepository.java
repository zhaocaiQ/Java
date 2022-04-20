package com.example.API.repository;

import com.example.API.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    //회원저장
    public void save(Member member) {
        em.persist(member);
    }

    //회원조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    //모든 회원조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //이메일로 회원조회
    public List<Member> findByEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
    }

    //닉네임으로 회원조회
    public List<Member> findByNickname(String nickname) {
        return em.createQuery("select m from Member m where m.nickname = :nickname", Member.class)
                .setParameter("nickname", nickname)
                .getResultList();
    }

    //회원삭제
    public void remove(Member member) {em.remove(member);}

}
