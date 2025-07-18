package com.example.demo.MemberJoin.post.domain;

import com.example.demo.MemberJoin.author.Domain.Member;
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
    private Long id;
    @Column(length = 254,nullable = false)
    private String title;
    @Column(length = 1000,nullable = false)
    private String contents;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private PostType postType = PostType.OPEN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    public void postModify(String newContents) {
        this.contents = newContents;
    }

}
