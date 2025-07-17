package com.example.demo.MemberJoin.post.repository;

import com.example.demo.MemberJoin.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PostRepository extends JpaRepository<Post,Long> {

}
