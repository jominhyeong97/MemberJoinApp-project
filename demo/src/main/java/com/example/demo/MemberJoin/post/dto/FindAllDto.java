package com.example.demo.MemberJoin.post.dto;

import com.example.demo.MemberJoin.author.Domain.PostType;
import com.example.demo.MemberJoin.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindAllDto {

    Long id;
    String title;
    String contents;
    PostType postType;

    public static FindAllDto fromEntity(Post post) {
        return new FindAllDto(post.getId(),post.getTitle(), post.getContents(), post.getPostType());
    }

}
