package com.kaykesilva.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaykesilva.hroauth.entities.User;
import com.kaykesilva.hroauth.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {
		User obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);
		}
		catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
}
