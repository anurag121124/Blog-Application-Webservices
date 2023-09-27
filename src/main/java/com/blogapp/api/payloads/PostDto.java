package com.blogapp.api.payloads;

import java.util.Date;

import com.blogapp.api.entities.Category;
import com.blogapp.api.entities.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {

  private String title;

  private String content;

  private String imageName;

  private Date addedDate;

  private CategoryDto category;

  private UserDto user;

}
