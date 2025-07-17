package com.example.demo.MemberJoin.Repository;

import com.example.demo.MemberJoin.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
//실수2
public interface Repository extends JpaRepository<Member,Long> {

}
