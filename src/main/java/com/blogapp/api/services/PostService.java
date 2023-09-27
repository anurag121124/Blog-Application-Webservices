package com.blogapp.api.services;

import java.util.List;

import com.blogapp.api.entities.Post;
import com.blogapp.api.payloads.PostDto;

public interface PostService {

    // create

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    Post updatePost(PostDto postDto, Integer postId);

    // Delete

    void deletePost(Integer postId);

    // getAll
    List<Post> getAllPosts();

    // get single post

    Post getPostById(Integer postId);

    // get all post by categeory

    List<Post> getPostsByCategory(Integer categoryId);

    // get all post by user

    List<Post> getPostByUser(Integer userId);

    // Search Post
    List<Post> serachPosts(String keyword);

}


// user dto