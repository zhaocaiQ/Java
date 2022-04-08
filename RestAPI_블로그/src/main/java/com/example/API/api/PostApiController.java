package com.example.API.api;

import com.example.API.domain.Member;
import com.example.API.domain.MemberStatus;
import com.example.API.domain.Post;
import com.example.API.service.PostService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private PostService postService;

//    @PostMapping("/api/posts")
//    public CreatePostResponse savePost(@RequestBody @Valid CreatePostRequest request) {
//
////        Post post = postService.Post(request.getTitle(), request.getContent());
//        return new CreatePostResponse(post.getId());
//    }

    @Data
    static class CreatePostResponse {
        private Long id;

        public CreatePostResponse(Long id) {
            this.id = id;
        }
    }

    //post등록 DTO
    @Data
    static class CreatePostRequest {
        @NotBlank(message = "제목을 입력해주세요.")
        private String title;
        @NotBlank(message = "내용을 입력해주세요.")
        private String content;
    }
}
