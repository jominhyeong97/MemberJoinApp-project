package com.example.demo.MemberJoin.post.dto;

import com.example.demo.MemberJoin.author.Domain.PostType;
import com.example.demo.MemberJoin.post.domain.Post;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DetailFindDto {
    Long id;
    String title;
    String contents;
    PostType postType;

    public static DetailFindDto fromEntity(Post post) {
        return DetailFindDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .contents(post.getContents())
                .postType(post.getPostType())
                .build();
    }

}
