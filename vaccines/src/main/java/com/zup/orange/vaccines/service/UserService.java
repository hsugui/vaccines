package com.zup.orange.vaccines.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

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

	public void addNewUser(UserForm userForm) {
		User user = userForm.convert();
		userRepository.save(user);
	}

//	public static ResponseEntity<UserDto> create(UserForm userForm, URI uri, UriComponentsBuilder uriComponentsBuilder) {
//		User user = userForm.convert();
//		uri = uriComponentsBuilder.path("/users").buildAndExpand(user).toUri();
//		return ResponseEntity.created(uri).body(new UserDto(user));
//	}

}
