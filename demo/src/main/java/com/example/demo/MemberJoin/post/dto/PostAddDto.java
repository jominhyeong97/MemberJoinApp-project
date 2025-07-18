package com.example.demo.MemberJoin.post.dto;

import com.example.demo.MemberJoin.author.Domain.Member;
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
    Long author_id;

    public static Post toEntity(PostAddDto postAddDto, Member member) {
        return Post.builder()
                .title(postAddDto.getTitle())
                .contents(postAddDto.getContents())
                .postType(postAddDto.getPostType())
                .member(member)
                .build();
    }


}
