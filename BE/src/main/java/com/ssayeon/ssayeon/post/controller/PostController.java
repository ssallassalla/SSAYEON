package com.ssayeon.ssayeon.post.controller;

import com.ssayeon.ssayeon.post.dto.NewPostRequest;
import com.ssayeon.ssayeon.post.dto.PostsResponse;
import com.ssayeon.ssayeon.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.net.URI;


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
}
