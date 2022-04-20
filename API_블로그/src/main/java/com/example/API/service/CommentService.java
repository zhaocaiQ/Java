package com.example.API.service;

import com.example.API.config.TokenUtils;
import com.example.API.domain.Comment;
import com.example.API.domain.Member;
import com.example.API.domain.Post;
import com.example.API.repository.CommentRepository;
import com.example.API.repository.MembersRepository;
import com.example.API.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final MembersRepository membersRepository;
    private final PostRepository postRepository;
    private final TokenUtils tokenUtils;

    //댓글 등록
    @Transactional
    public Comment saveComment(Long postId, String comment, String token) throws Exception {
        //멤버 조회
        Member member = membersRepository.findByEmail(tokenUtils.findMember(token))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        //게시글 조회
        Post post = postRepository.findOne(postId);
        if (post.getId() != postId) {
            throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
        }

        //댓글 생성
        Comment saveComment = new Comment();
        saveComment.setComment(comment);
        saveComment.setCreated_date(LocalDateTime.now());
        saveComment.setRemoved(false);
        saveComment.setPost(post);
        saveComment.setMember(member);

        //댓글 저장
        commentRepository.save(saveComment);
        return saveComment;
    }

    //대댓글 등록
    @Transactional
    public Comment saveReComment(Long postId, Long commentId, String comment, String token) throws Exception {

        //멤버 조회
        Member member = membersRepository.findByEmail(tokenUtils.findMember(token))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        //게시글 조회
        Post post = postRepository.findOne(postId);
        if (post.getId() != postId) {
            throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
        }

        //대댓글 생성
        Comment saveComment = new Comment();
        saveComment.setComment(comment);
        saveComment.setCreated_date(LocalDateTime.now());
        saveComment.setRemoved(false);
        saveComment.setPost(post);
        saveComment.setMember(member);
        saveComment.setParent(commentRepository.findOne(commentId));

        //대댓글 저장
        commentRepository.save(saveComment);
        return saveComment;
    }

    //댓글 수정
    @Transactional
    public void update(Long commentId, String comment, String token) throws Exception{
        //해당 댓글조회
        Comment findComment = commentRepository.findOne(commentId);
        //멤버 조회
        Member member = membersRepository.findByEmail(tokenUtils.findMember(token))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        if (findComment.getMember().getId() != member.getId()) {
            throw new IllegalArgumentException("수정할 수 없습니다.");
        }

        if (comment != null) {
            findComment.setComment(comment);
        }
        findComment.setModified_date(LocalDateTime.now());
    }

    //댓글 삭제
    @Transactional
    public Comment deleteById(Long commentId, String token) throws Exception {
        //해당 댓글조회
        Comment findComment = commentRepository.findOne(commentId);

        //멤버 조회
        Member member = membersRepository.findByEmail(tokenUtils.findMember(token))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        if (findComment.getMember().getId() != member.getId()) {
            throw new IllegalArgumentException("삭제할 수 없습니다.");
        }
        if (findComment == null) {
            throw new IllegalStateException("존재하지 않는 게시글입니다.");
        } else {
            commentRepository.remove(findComment);
            return findComment;
        }
    }

}
