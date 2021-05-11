package com.zup.orange.vaccines.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.orange.vaccines.controller.dto.UserDto;
import com.zup.orange.vaccines.controller.form.UserForm;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<UserDto> list() {
		return userService.getUsers();
	}
	
	@PostMapping
	public ResponseEntity<UserDto> register(@RequestBody @Valid UserForm userForm, UriComponentsBuilder uriComponentsBuilder) {
		User user = userForm.convert();
		userService.addNewUser(userForm);
		
		URI uri = uriComponentsBuilder.path("/user").buildAndExpand(user).toUri();
		return ResponseEntity.created(uri).body(new UserDto(user));
	}
	
}
