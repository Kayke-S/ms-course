package com.kaykesilva.hruser.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaykesilva.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	default User findByEmail(String email) {
		List<User> list = findAll();
		for(User obj: list) {
			if(obj.getEmail().equals(email)) {
				return obj;
			}
		}
		return null;
	}
	
}
