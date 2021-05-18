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
	public User getUserByCpf(String cpf) {
		Optional<User> user = userRepository.findUserByCpf(cpf);
		if (user.isPresent()) {
			return user.get();
		}
		throw new IllegalStateException("user with cpf " + cpf + " does not exist");
	}

	@Override
	public User addNewUser(UserForm userForm) {
		User user = userForm.convert();
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public User updateUser(String cpf, UserUpdateForm form) {
		Optional<User> userOptional = userRepository.findUserByCpf(cpf);
		if (userOptional.isPresent())	{
			return form.update(cpf, userRepository);
		}
		throw new IllegalStateException("user with id " + cpf + " does not exist");
	}

	@Override
	public void deleteUser(String cpf) {
		Optional<User> user = userRepository.findUserByCpf(cpf);
		if (user.isPresent()) {
			Long userId = user.get().getId();
			userRepository.deleteById(userId);
		}
		throw new IllegalStateException("user with cpf " + cpf + " does not exist");
	}

}
