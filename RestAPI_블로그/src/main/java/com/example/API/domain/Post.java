package com.example.API.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //==연관관계 편의메소드==//
    public void changeMember(Member member) {
        this.member = member;
        member.getPosts().add(this);
    }

    //==생성메소드==//
    public static Post createPost(Member member, String title, String content) {
        Post post = new Post();
        post.changeMember(member);
        post.setTitle(title);
        post.setContent(content);
        post.setCreated_date(LocalDateTime.now());
        return post;
    }
}
