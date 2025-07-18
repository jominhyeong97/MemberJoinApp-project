package com.example.demo.MemberJoin.post.service;
import com.example.demo.MemberJoin.author.Repository.Repository;
import com.example.demo.MemberJoin.post.domain.Post;
import com.example.demo.MemberJoin.post.dto.DetailFindDto;
import com.example.demo.MemberJoin.post.dto.FindAllDto;
import com.example.demo.MemberJoin.post.dto.PatchDto;
import com.example.demo.MemberJoin.post.dto.PostAddDto;
import com.example.demo.MemberJoin.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class PostService {

    final public PostRepository postRepository;
    final public Repository memberRepository;

    @Autowired
    public PostService(PostRepository postRepository, Repository memberRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }


    public void postAdd(PostAddDto postAddDto) {
        Post post = PostAddDto.toEntity(postAddDto);
        postRepository.save(post);
    }

    public List<FindAllDto> findAll() {
        return postRepository.findAll().stream().map(FindAllDto::fromEntity).collect(Collectors.toList());
    }

    public DetailFindDto findDetail(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new EntityNotFoundException("id에맞는 글이없습니다."));
        return DetailFindDto.fromEntity(post);
    }

    public void modify(PatchDto patchDto) {
        Post post = postRepository.findById(patchDto.getId()).orElseThrow(()->new EntityNotFoundException("id에맞는 글이없습니다."));
        post.postModify(patchDto.getContents());
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new EntityNotFoundException("id에맞는 글이없습니다."));
        postRepository.delete(post);
    }


}
