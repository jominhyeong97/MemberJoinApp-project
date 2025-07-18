package com.example.demo.MemberJoin.author.Dto;

import com.example.demo.MemberJoin.author.Domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindDetailDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;


    public static FindDetailDto fromEntity(Member member) {
        return FindDetailDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .address(member.getAddress())
                .createdTime(member.getCreatedTime())
                .updateTime(member.getUpdateTime())
                .build();
    }

}
