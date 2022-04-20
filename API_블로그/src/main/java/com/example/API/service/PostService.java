package com.example.API.service;

import com.example.API.config.TokenUtils;
import com.example.API.domain.Member;
import com.example.API.domain.Post;
import com.example.API.repository.MembersRepository;
import com.example.API.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MembersRepository membersRepository;
    private final TokenUtils tokenUtils;

    //게시글 등록
    @Transactional
    public Post Post(String title, String content, String token) throws Exception {
        //멤버 조회
        Member member = membersRepository.findByEmail(tokenUtils.findMember(token))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        //게시글 생성
        Post post = Post.createPost(member, title, content);
        //게시글 저장
        postRepository.save(post);
        return post;
    }

    //게시글 수정
    @Transactional
    public void update(Long id, String title, String content, String token) throws Exception{
        Post post = postRepository.findOne(id);
        //멤버 조회
        Member member = membersRepository.findByEmail(tokenUtils.findMember(token))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        if (post.getMember().getId() != member.getId()) {
            throw new IllegalArgumentException("수정할 수 없습니다.");
        }
        if (title != null) {
            post.setTitle(title);
        }
        if (content != null) {
            post.setContent(content);
        }
        post.setModified_date(LocalDateTime.now());
    }


    //게시글삭제
    @Transactional
    public Post deleteById(Long id, String token) throws Exception {
        Post post = postRepository.findOne(id);

        //멤버 조회
        Member member = membersRepository.findByEmail(tokenUtils.findMember(token))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        if (post.getMember().getId() != member.getId()) {
            throw new IllegalArgumentException("삭제할 수 없습니다.");
        }
        if (post == null) {
            throw new IllegalStateException("존재하지 않는 게시글입니다.");
        } else {
            postRepository.remove(post);
            return post;
        }
    }

}
