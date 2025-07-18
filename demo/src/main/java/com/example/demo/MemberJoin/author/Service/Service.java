package com.example.demo.MemberJoin.author.Service;

import com.example.demo.MemberJoin.author.Domain.Member;
import com.example.demo.MemberJoin.author.Dto.CreateDto;
import com.example.demo.MemberJoin.author.Dto.FindAllDto;
import com.example.demo.MemberJoin.author.Dto.FindDetailDto;
import com.example.demo.MemberJoin.author.Repository.Repository;
import jakarta.persistence.EntityExistsException;
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

    public void save(CreateDto createDto) throws EntityExistsException{
        if(repository.findByEmail(createDto.getEmail()).isEmpty()) {
            repository.save(createDto.toEntity());
        } else  {
            throw new EntityExistsException("해당 이메일이 존재합니다.");
        }
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

//            회원상세조회(email로)
        public FindDetailDto findByEmail(String email) {
            return FindDetailDto.fromEntity(repository.findByEmail(email).
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
