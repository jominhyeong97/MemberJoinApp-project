package com.example.demo.MemberJoin.Dto;

import com.example.demo.MemberJoin.Domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindDetailDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;

    public static FindDetailDto fromEntity (Member member) {
        return new FindDetailDto(member.getId(),member.getName(),member.getEmail(),member.getPassword(),
                member.getAddress(),member.getCreatedTime(),member.getUpdateTime());
    }
}
