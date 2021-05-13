package com.zup.orange.vaccines.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.orange.vaccines.controller.dto.UserDto;
import com.zup.orange.vaccines.controller.form.UserForm;
import com.zup.orange.vaccines.controller.form.UserUpdateForm;
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

	@Transactional
	public User updateUser(Long id, UserUpdateForm form) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent())	{
			return form.update(id, userRepository);
		}
		throw new IllegalStateException("user with id " + id + " does not exist");
	}

	public void deleteUser(Long id) {
		boolean exists = userRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("user with id " + id + " does not exist");
		}
		userRepository.deleteById(id);
	}
}
