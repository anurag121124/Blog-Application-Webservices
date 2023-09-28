package com.blogapp.api.services;

import java.util.List;

import com.blogapp.api.entities.Post;
import com.blogapp.api.payloads.PostDto;
import com.blogapp.api.payloads.PostResponse;

public interface PostService {

    // create

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    PostDto updatePost(PostDto postDto, Integer postId);

    // Delete

    void deletePost(Integer postId);

    // getAll
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize , String sortBy,String sortDir);

    // get single post

    PostDto getPostById(Integer postId);

    // get all post by categeory

    List<PostDto> getPostsByCategory(Integer categoryId);

    // get all post by user

    List<PostDto> getPostsByUser(Integer userId);

    // Search Post
	List<PostDto> searchPosts(String keyword);

}

