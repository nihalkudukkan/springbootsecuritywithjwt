package io.getarray.userservice;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.getarray.userservice.domain.Role;
import io.getarray.userservice.domain.User;
import io.getarray.userservice.service.UserService;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	CommandLineRunner run(UserService userservice) {
//		return args->{
//			userservice.saveRole(new Role(null, "ROLE_USER"));
//			userservice.saveRole(new Role(null, "ROLE_MANAGER"));
//			userservice.saveRole(new Role(null, "ROLE_ADMIN"));
//			userservice.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//			
//			userservice.saveUser(new User(null, "Nihal K", "nihal", "1234", new ArrayList<>()));
//			userservice.saveUser(new User(null, "Fasal K", "fasal", "1234", new ArrayList<>()));
//			userservice.saveUser(new User(null, "Sahal K", "sahal", "1234", new ArrayList<>()));
//			userservice.saveUser(new User(null, "Jim Curry", "jim", "1234", new ArrayList<>()));
//			
//			userservice.addRoleToUser("nihal", "ROLE_USER");
//			userservice.addRoleToUser("nihal", "ROLE_MANAGER");
//			userservice.addRoleToUser("fasal", "ROLE_MANAGER");
//			userservice.addRoleToUser("sahal", "ROLE_ADMIN");
//			userservice.addRoleToUser("jim", "ROLE_SUPER_ADMIN");
//			userservice.addRoleToUser("jim", "ROLE_ADMIN");
//			userservice.addRoleToUser("jim", "ROLE_USER");
//		};
//	}
	
}
