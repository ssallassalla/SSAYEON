package com.ssayeon.ssayeon.post.controller;

import com.ssayeon.ssayeon.post.dto.NewPostRequest;
import com.ssayeon.ssayeon.post.dto.PostUpdateRequest;
import com.ssayeon.ssayeon.post.dto.PostsResponse;
import com.ssayeon.ssayeon.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.net.URI;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping("/posts/create")
    public ResponseEntity<Void> addPost(@Valid @RequestBody NewPostRequest newPostRequest) {
        postService.addPost(newPostRequest);
        return ResponseEntity.created(URI.create("/posts")).build();
    }

    @GetMapping("/posts")
    public ResponseEntity<PostsResponse> findPosts() {
        PostsResponse postsResponse = postService.findPosts();
        return ResponseEntity.ok(postsResponse);
    }
    @PutMapping("/posts/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable("id") Long id,
                                           @Valid @RequestBody PostUpdateRequest postUpdateRequest
                                           ) {
        postService.updatePost(id, postUpdateRequest);

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

}
