package com.blogapp.api.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")

@NoArgsConstructor
@Getter 
@Setter

public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column(name = "user_name" ,nullable=false, length =100)

@NotNull
private String name ;
@Email
private String email;
@NotNull
private String password;
@NotNull
private String about;

	
}
