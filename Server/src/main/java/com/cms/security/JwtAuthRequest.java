package com.cms.security;

import lombok.Data;

@Data
public class JwtAuthRequest {
	
	private String username;
	private String password;

}
