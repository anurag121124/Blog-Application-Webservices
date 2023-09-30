package com.blogapp.api.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

   @NotEmpty
   @Size(min = 4 , message = "User name must be minimum four charcters")
    private String name;

    @Email(message = "Email should be valid")
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10,message = "Passeword must be minimum of 3 char and maximum of 10 char")
    private String password;

    @NotEmpty
    @Size(min = 10, max = 200, message
            = "About Me must be between 10 and 200 characters")
    private String about;
}
