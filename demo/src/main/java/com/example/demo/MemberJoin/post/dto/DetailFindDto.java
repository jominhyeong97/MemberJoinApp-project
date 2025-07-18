package com.example.demo.MemberJoin.post.dto;

import com.example.demo.MemberJoin.author.Domain.PostType;
import com.example.demo.MemberJoin.post.domain.Post;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DetailFindDto {
    private Long id;
    private String title;
    private String contents;
    private PostType postType;
    private String author_email;
    private Long author_id;

    public static DetailFindDto fromEntity(Post post) {
        return DetailFindDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .contents(post.getContents())
                .postType(post.getPostType())
                .author_email(post.getMember().getEmail())
                .build();
    }

}
