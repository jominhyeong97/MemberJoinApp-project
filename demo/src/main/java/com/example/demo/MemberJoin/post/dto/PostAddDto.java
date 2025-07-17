package com.example.demo.MemberJoin.post.dto;

import com.example.demo.MemberJoin.author.Domain.PostType;
import com.example.demo.MemberJoin.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class PostAddDto {
    String title;
    String contents;
    PostType postType;

    public static Post toEntity(PostAddDto postAddDto) {
        return Post.builder()
                .title(postAddDto.getTitle())
                .contents(postAddDto.getContents())
                .postType(postAddDto.getPostType())
                .build();
    }


}
