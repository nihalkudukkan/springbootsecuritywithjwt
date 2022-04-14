package io.getarray.userservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	@Id
	private String id;
	private String name;
}
