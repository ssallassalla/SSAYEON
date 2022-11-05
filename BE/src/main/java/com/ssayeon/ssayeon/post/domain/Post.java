package com.ssayeon.ssayeon.post.domain;

import lombok.Builder;
import lombok.Getter;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    @Getter
    private Long id;

    @Embedded
    private Title title;

    @Embedded
    private Content content;

    @Getter
    private int viewCount = 0;

    @Getter
    private int likeCount = 0;

    @Getter
    private String imageUrl;

    @Getter
    @CreatedDate
    private LocalDateTime createdAt;

    @Getter
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    protected Post () {

    }

    // TODO: 2022-11-05  comments, postHashTags, postBoards
    @Builder
    private Post(String title, String content, String imageUrl) {
        this.title = new Title(title);
        this.content = new Content(content);
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title.getValue();
    }

    public String getContent() {
        return content.getValue();
    }


}
