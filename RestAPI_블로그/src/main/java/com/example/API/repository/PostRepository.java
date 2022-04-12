//package com.example.API.repository;
//
//import com.example.API.domain.Post;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class PostRepository {
//
//    private final EntityManager em;
//
//    //게시글 등록
//    public void save(Post post) {em.persist(post);}
//
//    //게시글 조회
//    public Post findOne(Long id) { return em.find(Post.class, id);}
//
//    //게시글 전체조회
//    public List<Post> findAll(Post post) {
//        return em.createQuery("select p from Post p", Post.class)
//                .getResultList();
//    }
//
//    //게시글 페이징 조회
//    public List<Post> findPaging(int offset, int limit) {
//        return em.createQuery(
//                "select p from Post p" +
//                " join fetch o.member m", Post.class)
//                .setFirstResult(offset)
//                .setMaxResults(limit)
//                .getResultList();
//    }
//
//    //게시글 삭제
//    public void remove(Post post) {em.remove(post);}
//
//}
