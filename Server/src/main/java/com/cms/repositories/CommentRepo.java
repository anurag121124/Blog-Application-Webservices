package com.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
