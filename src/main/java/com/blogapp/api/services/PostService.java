package com.blogapp.api.services;

import java.util.List;

import com.blogapp.api.entities.Post;
import com.blogapp.api.payloads.PostDto;

public interface PostService {

    // create

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    PostDto updatePost(PostDto postDto, Integer postId);

    // Delete

    void deletePost(Integer postId);

    // getAll
    List<PostDto> getAllPosts();

    // get single post

    PostDto getPostById(Integer postId);

    // get all post by categeory

    List<PostDto> getPostsByCategory(Integer categoryId);

    // get all post by user

    List<PostDto> getPostsByUser(Integer userId);

    // Search Post
    List<PostDto> serachPosts(String keyword);

}

