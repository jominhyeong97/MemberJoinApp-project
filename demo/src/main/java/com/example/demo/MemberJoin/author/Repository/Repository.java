package com.example.demo.MemberJoin.author.Repository;

import com.example.demo.MemberJoin.author.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
//실수2
public interface Repository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
}
