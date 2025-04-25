package com.Adepu.User.Controller;


import com.Adepu.User.Service.UserService;
import com.Adepu.User.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
	
	UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/user/{id}")
	public User getSingleUser(@PathVariable("id") long id) {
		User SingleUser;
		SingleUser = userService.getSingleUser(id);
		
		return SingleUser;
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers() {
		List<User> users = userService.getAllUsers();
		
		
		return users;
	}
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user) {
		User savedUser = userService.postUser(user.getName(),
				user.getEmail(),
				user.getPhone(),
				user.getGender());
		return savedUser;
	}
}
