package com.nhnacademy.board.service;

import com.nhnacademy.board.domain.ConcretePost;
import com.nhnacademy.board.domain.Post;
import com.nhnacademy.board.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPostList() {
        return postRepository.getPosts();
    }

    public ConcretePost getPostId(Long id) {
        ConcretePost post = postRepository.getPost(id);
        return post;
    }

    //ㄱㅔ시물번ㅊ
    public Long getId() {
        List<Post> postList = postRepository.getPosts();
        int size = postList.size()-1;
        Long id = Long.valueOf(postList.get(size).getId());
        return id+1;
    }

    public void register(Post post) { postRepository.register(post);}



}
