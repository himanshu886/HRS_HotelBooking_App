package com.himanshu.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
		
		private Integer id;
		
		@NotEmpty
		@Size(min = 4, message = "Username must be min of 4 characters !!")
		private String name;
		
		//@notEmpty will check notNull as well as NotEmpty
		
		@Email(message = "Email address is not valid!!")
		private String email;
		
		@NotNull
		@Size(min = 3, max = 10, message = "Password must be min of 3 char and max of 10 chars!!")
		private String password;
		
		@NotNull
		private String about;
}
