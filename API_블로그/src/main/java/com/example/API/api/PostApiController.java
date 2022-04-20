package com.example.API.api;

import com.example.API.domain.Post;
import com.example.API.repository.PostRepository;
import com.example.API.service.PostService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;
    private final PostRepository postRepository;

    //게시글 등록
    @PostMapping("/api/posts")
    public CreatePostResponse savePost(@RequestBody @Valid CreatePostRequest request) throws Exception {
        System.out.println("1.title: " + request.getTitle());
        System.out.println("1.content: " + request.getContent());
        System.out.println("1.token: " + request.getToken());
        Post post = postService.Post(request.getTitle(), request.getContent(), request.getToken());
        System.out.println("1.post: " + post);
        return new CreatePostResponse(post);
    }

    @Data
    static class CreatePostResponse {
        private Long id;
        private String title;
        private String content;
        private String nickname;


        public CreatePostResponse(Post post) {
            this.id = post.getId();
            this.title = post.getTitle();
            this.content = post.getContent();
            this.nickname = post.getMember().getNickname();
        }
    }

    //post등록 DTO
    @Data
    static class CreatePostRequest {
        @NotBlank(message = "제목을 입력해주세요.")
        private String title;
        @NotBlank(message = "내용을 입력해주세요.")
        private String content;
        private String token;
    }

    //게시글 조회
    @GetMapping("api/posts")
    public Result findKeyPosts(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                               @RequestParam(value = "offset", defaultValue = "0") int offset,
                               @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<Post> posts = postRepository.findKeywordPost(keyword, offset, limit);
        List<PostDto> collect = posts.stream()
                .map(post -> new PostDto(post))
                .collect(Collectors.toList());
        return new Result(collect.size(), collect);
    }

    @Data
    static class PostDto {
        private Long id;
        private String title;
        private String content;
        private String nickname;
        private LocalDateTime created_date;

        public PostDto(Post post) {
            id = post.getId();
            title = post.getTitle();
            content = post.getContent();
            nickname = post.getMember().getNickname();
            created_date = post.getCreated_date();
        }
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

    //게시글 수정
    @PutMapping("/api/posts/{id}")
    public UpdatePostResponse updatePost(@PathVariable("id") Long id,
                                                                 @RequestBody @Valid UpdatePostRequest request) throws Exception {

        postService.update(id, request.getTitle(), request.getContent(), request.getToken());
        Post findPost = postRepository.findOne(id);
        System.out.println(findPost);
        return new UpdatePostResponse(findPost.getId(), findPost.getTitle(), findPost.getContent(), findPost.getMember().getNickname());
    }

    @Data
    @AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 생성
    static class UpdatePostResponse {
        private Long id;
        private String title;
        private String content;
        private String nickname;
    }

    @Data
    static class UpdatePostRequest {
        private String title;
        private String content;
        private String token;
    }

    //게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public DeleteResponse deletePost(@PathVariable("id") Long id,
                                     @RequestBody @Valid DeleteRequest request) throws Exception {
        Post deletePost = postService.deleteById(id, request.getToken());
        return new DeleteResponse(deletePost.getId(), deletePost.getTitle(), deletePost.getMember().getNickname());
    }

    @Data
    static class DeleteRequest {
        private String token;
    }

    @Data
    @AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 생성
    static class DeleteResponse {
        private Long id;
        private String title;
        private String nickname;

    }

}
