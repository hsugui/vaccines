package com.zup.orange.vaccines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.orange.vaccines.controller.dto.UserDto;
import com.zup.orange.vaccines.controller.form.UserForm;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<UserDto> getUsers() {
		List<User> users = userRepository.findAll();
		return UserDto.convert(users);
	}

	public User addNewUser(UserForm userForm) {
		User user = userForm.convert();
		return userRepository.save(user);
	}

}
