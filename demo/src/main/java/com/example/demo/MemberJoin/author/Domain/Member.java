package com.example.demo.MemberJoin.author.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


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
