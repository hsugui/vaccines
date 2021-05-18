package com.zup.orange.vaccines.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zup.orange.vaccines.controller.dto.UserDto;
import com.zup.orange.vaccines.controller.form.UserForm;
import com.zup.orange.vaccines.controller.form.UserUpdateForm;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.repository.UserRepository;
import com.zup.orange.vaccines.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<UserDto> getUsers() {
		List<User> users = userRepository.findAll();
		return UserDto.convert(users);
	}
	
	@Override
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		throw new IllegalStateException("user with id " + id + " does not exist");
	}

	@Override
	public User addNewUser(UserForm userForm) {
		User user = userForm.convert();
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public User updateUser(Long id, UserUpdateForm form) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent())	{
			return form.update(id, userRepository);
		}
		throw new IllegalStateException("user with id " + id + " does not exist");
	}

	@Override
	public void deleteUser(Long id) {
		boolean exists = userRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("user with id " + id + " does not exist");
		}
		userRepository.deleteById(id);
	}

}
