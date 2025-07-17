package com.example.demo.MemberJoin.post.controller;

import com.example.demo.MemberJoin.post.dto.DetailFindDto;
import com.example.demo.MemberJoin.post.dto.PatchDto;
import com.example.demo.MemberJoin.post.dto.PostAddDto;
import com.example.demo.MemberJoin.post.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testpost")

public class PostController {
    final public PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

//    게시글 작성
    @PostMapping("/add")
    public ResponseEntity<?> addPost(@Valid @RequestBody PostAddDto postAddDto) {
        postService.postAdd(postAddDto);
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }
//    게시글 조회
    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(postService.findAll(),HttpStatus.FOUND);
    }
//    게시글 상세조회
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> findById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>( postService.findDetail(id),HttpStatus.FOUND);
    }

//    게시글 수정(id가 일치해야함)
    @PatchMapping("/patch")
    public ResponseEntity<?> modify(@Valid @RequestBody PatchDto patchDto) {
        System.out.println(patchDto.getId());
        System.out.println(patchDto.getContents());
        postService.modify(patchDto);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

//    게시글 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable Long id) {
        System.out.println(id);
        postService.delete(id);
        return new ResponseEntity<>("ok", HttpStatus.OK);

    }
}
