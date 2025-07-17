package com.example.demo.MemberJoin.author.Dto;

import com.example.demo.MemberJoin.author.Domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateDto {

    private String name;
    private String email;
    private String password;
    private String address;

    public CreateDto fromEntity(Member member) {
        return new CreateDto(member.getName(),member.getEmail(),member.getPassword(),member.getAddress());
    }

    public Member toEntity() {
        return new Member(this.name,this.email,this.password,this.address);
    }

}
