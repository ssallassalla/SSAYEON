package com.ssayeon.ssayeon.post.service;


import com.ssayeon.ssayeon.post.domain.Post;
import com.ssayeon.ssayeon.post.dto.NewPostRequest;
import com.ssayeon.ssayeon.post.dto.PostsResponse;
import com.ssayeon.ssayeon.post.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Long addPost(NewPostRequest newPostRequest) {
        Post post = createPost(newPostRequest);

        Post savedPost = postRepository.save(post);
        return savedPost.getId();
    }

    private Post createPost(NewPostRequest newPostRequest) {
        return Post.builder()
                .title(newPostRequest.getTitle())
                .content(newPostRequest.getContent())
                .imageUrl(newPostRequest.getImageUrl())
                .build();
    }

    public PostsResponse findPosts() {
        List<Post> posts = postRepository.findAll();
        return PostsResponse.ofPostList(posts);
    }
}
