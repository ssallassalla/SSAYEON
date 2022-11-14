package com.ssayeon.ssayeon.post.repository;

import com.ssayeon.ssayeon.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAll();
    Post save(Post post);

}
