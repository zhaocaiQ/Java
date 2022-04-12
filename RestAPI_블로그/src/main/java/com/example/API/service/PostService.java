//package com.example.API.service;
//
//import com.example.API.domain.Member;
//import com.example.API.domain.Post;
//import com.example.API.repository.MemberRepository;
//import com.example.API.repository.PostRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class PostService {
//
//    private final PostRepository postRepository;
//    private final MemberRepository memberRepository;

//    @Transactional
//    public Long Post(Long memberId, String title, String content) {
//        //엔티티 조회
//        Member member = memberRepository.findOne(memberId);
//
//        //게시글 생성
//        Post post = Post.createPost(member, title, content);
//        //게시글 저장
//        postRepository.save(post);
//        return post.getId();
//    }
//}
