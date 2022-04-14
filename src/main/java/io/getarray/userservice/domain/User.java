package io.getarray.userservice.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String id;
	private String name;
	private String username;
	private String password;
	private List<Role> roles;	
	
}
