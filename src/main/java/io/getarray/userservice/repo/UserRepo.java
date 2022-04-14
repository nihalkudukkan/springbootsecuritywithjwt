package io.getarray.userservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.getarray.userservice.domain.User;

public interface UserRepo extends MongoRepository<User, String>{
	User findByUsername(String username);
}
