package com.example.demo.MemberJoin.post.domain;

import com.example.demo.MemberJoin.author.Domain.PostType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 254,nullable = false)
    String title;
    @Column(length = 1000,nullable = false)
    String contents;
    @Enumerated(EnumType.STRING)
    PostType postType;


    public void postModify(String newContents) {
        this.contents = newContents;
    }

}
