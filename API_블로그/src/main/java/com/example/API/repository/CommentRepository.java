package com.example.API.repository;

import com.example.API.domain.Comment;
import com.example.API.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    //댓글 등록
    public void save(Comment comment) {em.persist(comment);}

    //댓글 조회
    public Comment findOne(Long id) {
        return em.find(Comment.class, id);
    }

    //댓글 모두조회
    public List<Comment> findAllComment(Long id, int offset, int limit) {
        return em.createQuery("select c from Comment c where c.post.id = :id", Comment.class)
                .setParameter("id", id)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    //게시글 삭제
    public void remove(Comment comment) {em.remove(comment);}
}
