package com.example.API.api;

import antlr.StringUtils;
import com.example.API.domain.Comment;
import com.example.API.domain.Post;
import com.example.API.repository.CommentRepository;
import com.example.API.repository.PostRepository;
import com.example.API.service.CommentService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    //댓글 등록
    @PostMapping("/api/posts/{postId}/comments")
    public CreateCommentResponse createComment(@PathVariable("postId") Long postId,
                                               @RequestBody @Valid CreateCommentRequest request) throws Exception {
        Comment comment = commentService.saveComment(postId, request.getComment(), request.getToken());

        return new CreateCommentResponse(comment.getId());
    }

    //대댓글 등록
    @PostMapping("/api/posts/{postId}/comments/{commentId}")
    public CreateCommentResponse createReComment(@PathVariable("postId") Long postId,
                                                 @PathVariable("commentId") Long commentId,
                                                 @RequestBody @Valid CreateCommentRequest request) throws Exception {
        System.out.println("1.request: " + request);
        Comment comment = commentService.saveReComment(postId, commentId, request.getComment(), request.getToken());

        return new CreateCommentResponse(comment.getId());
    }

    @Data
    static class CreateCommentResponse {
        private Long id;

        public CreateCommentResponse(Long id) {
            this.id = id;
        }
    }

    //댓글등록 DTO
    @Data
    static class CreateCommentRequest {
        @NotBlank(message = "내용을 입력해주세요.")
        private String comment;
        private String token;
    }


    //댓글, 대댓글 모두조회
    @GetMapping("api/posts/{id}/comments")
    public Result findComment(@PathVariable("id") Long id,
                              @RequestParam(value = "offset", defaultValue = "0") int offset,
                              @RequestParam(value = "limit", defaultValue = "10") int limit) {

        List<Comment> comments = commentRepository.findAllComment(id, offset, limit);
        List<CommentDto> collect = comments.stream()
                .map(c -> new CommentDto(c))
                .collect(Collectors.toList());
        return new Result(collect.size(), collect);
    }

    @Data
    static class CommentDto {
        private Long id;
        private Long commentId;
        private String comment;
        private String nickname;

        public CommentDto(Comment com) {
            id = com.getId();
            comment = com.getComment();
            //commentId는 null이 아닐때만 값 할당
            if (com.getParent() != null) {
                commentId = com.getParent().getId();
            }
            nickname = com.getMember().getNickname();
        }
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

    //댓글 수정
    @PutMapping("/api/comments/{commentId}")
    public UpdateCommentResponse updateComment(@PathVariable("commentId") Long commentId,
                                               @RequestBody @Valid UpdateCommentRequest request) throws Exception {

        commentService.update(commentId, request.getComment(), request.getToken());
        Comment findComment = commentRepository.findOne(commentId);
        return new UpdateCommentResponse(findComment.getId(), findComment.getComment(), findComment.getMember().getNickname());
    }

    @Data
    @AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 생성
    static class UpdateCommentResponse {
        private Long id;
        private String comment;
        private String nickname;
    }

    @Data
    static class UpdateCommentRequest {
        private String comment;
        private String token;
    }

    //댓글 삭제
    @DeleteMapping("/api/comments/{commentId}")
    public DeleteResponse deletePost(@PathVariable("commentId") Long commentId,
                                     @RequestBody @Valid DeleteRequest request) throws Exception {
        Comment deleteComment = commentService.deleteById(commentId, request.getToken());
        return new DeleteResponse(deleteComment.getId(), deleteComment.getComment(), deleteComment.getMember().getNickname());
    }

    @Data
    static class DeleteRequest {
        private String token;
    }

    @Data
    @AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 생성
    static class DeleteResponse {
        private Long id;
        private String comment;
        private String nickname;

    }
}

