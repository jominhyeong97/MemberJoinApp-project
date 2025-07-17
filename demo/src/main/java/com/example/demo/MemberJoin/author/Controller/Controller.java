package com.example.demo.MemberJoin.author.Controller;

import com.example.demo.MemberJoin.author.Dto.CreateDto;
import com.example.demo.MemberJoin.author.Dto.UpdateDto;
import com.example.demo.MemberJoin.author.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member")
@RestController

public class Controller {


    public final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

//    회원가입
    @PostMapping("/save")
    public ResponseEntity<?> save(@ModelAttribute CreateDto createDto) {
        System.out.println(createDto);
        service.save(createDto);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

//    회원목록조회
    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(),HttpStatus.FOUND);
    }
//    회원상세조회(id로)
    @GetMapping("/detailList/{id}")
    public ResponseEntity<?> findDetail(@PathVariable Long id) {
        return new ResponseEntity<>(service.findDetail(id),HttpStatus.FOUND);
    }
//    회원정보수정(id로)
    @PatchMapping("/patch")
    public ResponseEntity<?> update(@RequestBody UpdateDto updateDto) {
        service.update(updateDto.getId(), updateDto.getNewPassword());
        System.out.println(updateDto.getId());
        System.out.println(updateDto.getNewPassword());
        return new ResponseEntity<>("ok",HttpStatus.CREATED);
    }
//    회원탈퇴
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }



}
