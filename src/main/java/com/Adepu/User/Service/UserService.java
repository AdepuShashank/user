package com.Adepu.User.Service;

import com.Adepu.User.Exceptions.UserNotFoundException;
import com.Adepu.User.Repository.UserRepository;
import com.Adepu.User.model.Gender;
import com.Adepu.User.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User getSingleUser(long id) throws UserNotFoundException {
		Optional<User> GetSingleUserById = userRepository.findById(id);
		User us;
		if(GetSingleUserById.isEmpty()) {
			throw new UserNotFoundException("no user with that id");
			
		}
		else {
			us = GetSingleUserById.get();
		}
		return us;
	}
	
	public List<User> getAllUsers() {
		List<User> userFromDB = userRepository.findAll();
		
		List<User> user = new ArrayList<>();
		
		for(User p : userFromDB) {
			User users = new User();
			
			users.setId(p.getId());
			users.setName(p.getName());
			users.setEmail(p.getEmail());
			users.setPhone(p.getPhone());
			
			
			user.add(users);
		}
		return user;
	}
	public User postUser(String name, String email, String phone , Gender gender) {
		User saveuser = new User();
		
		saveuser.setName(name);
		saveuser.setEmail(email);
		saveuser.setPhone(phone);
		saveuser.setGender(gender);
		
		User savedUser = userRepository.save(saveuser);
		
		return savedUser;
	}
}
