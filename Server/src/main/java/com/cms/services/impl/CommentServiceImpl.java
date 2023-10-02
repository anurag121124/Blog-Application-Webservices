package com.cms.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entities.Comment;
import com.cms.entities.Post;
import com.cms.entities.User;
import com.cms.exceptions.ResourceNotFoundException;
import com.cms.payload.CommentDto;
import com.cms.repositories.CommentRepo;
import com.cms.repositories.PostRepo;
import com.cms.repositories.UserRepo;
import com.cms.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		comment.setUser(user);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));

		this.commentRepo.delete(comment);

	}

}
