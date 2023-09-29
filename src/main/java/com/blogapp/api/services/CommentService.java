package com.blogapp.api.services;
import  com.blogapp.api.payloads.CommentDto;;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment (Integer commentId);

    
}
