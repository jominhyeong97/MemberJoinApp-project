package com.example.demo.MemberJoin.Service;

import com.example.demo.MemberJoin.Domain.Member;
import com.example.demo.MemberJoin.Dto.CreateDto;
import com.example.demo.MemberJoin.Dto.FindAllDto;
import com.example.demo.MemberJoin.Dto.FindDetailDto;
import com.example.demo.MemberJoin.Repository.Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//실수1
@Transactional
@org.springframework.stereotype.Service

public class Service {

    final public Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    //    회원가입

    public void save(CreateDto createDto) {
        repository.save(createDto.toEntity());
    }

    //    회원목록조회
    public List<FindAllDto> findAll() {
        List<FindAllDto> findAllDtoList = new ArrayList<>();
        for(Member a : repository.findAll()) {
            findAllDtoList.add(FindAllDto.fromEntity(a));
        }
        return findAllDtoList;

    }
        //    회원상세조회(id로)
        public FindDetailDto findDetail(Long id) {
            return FindDetailDto.fromEntity(repository.findById(id).
                    orElseThrow(()->new NoSuchElementException("값이없습니다.")));
        }

    //    비밀번호정보수정(id로)
    public void update(Long id,String newPassword) {
        Member member = repository.findById(id).
                orElseThrow(()->new NoSuchElementException("값이없습니다."));
        member.updatePassword(newPassword);
    }

    //    회원탈퇴
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
