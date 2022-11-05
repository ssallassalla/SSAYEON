package com.ssayeon.ssayeon.post.dto;

import com.ssayeon.ssayeon.post.domain.Post;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsResponse {

    private final List<PostsElementResponse> posts;

    public PostsResponse(List<PostsElementResponse> posts) {
        this.posts = posts;
    }

    public static PostsResponse ofPostList(List<Post> postList) {
        List<PostsElementResponse> postsElementResponses = postList
                .stream()
                .map(PostsElementResponse::from)
                .collect(Collectors.toList());
        return new PostsResponse(postsElementResponses);
    }
}