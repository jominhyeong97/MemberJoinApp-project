package com.example.demo.MemberJoin.author.Domain;

import com.example.demo.MemberJoin.post.domain.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;
    @NotEmpty
    @Column(unique = true)
    private String email;
    @Column(length = 8)
    private String password;
    private String address;

    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;

    @OneToMany(fetch = FetchType.LAZY)
    @Builder.Default
    private List<Post> postList = new ArrayList<>();

    public Member(String name, String email, String password, String address) {
        this.name=name;
        this.email=email;
        this.password=password;
        this.address=address;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

}
