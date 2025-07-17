package com.example.demo.MemberJoin.author.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CommonErrorDto {
    private String value;
    private int errorValue;
}
