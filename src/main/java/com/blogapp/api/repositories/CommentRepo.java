package com.blogapp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.api.entities.Comment;

public interface CommentRepo  extends JpaRepository<Comment	, Integer> {

}
