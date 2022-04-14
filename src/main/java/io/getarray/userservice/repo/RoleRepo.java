package io.getarray.userservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.getarray.userservice.domain.Role;

public interface RoleRepo extends MongoRepository<Role, String> {
	Role findByName(String name);
}
