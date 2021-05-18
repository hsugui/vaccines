package com.zup.orange.vaccines.service;

import java.util.List;

import com.zup.orange.vaccines.controller.dto.UserDto;
import com.zup.orange.vaccines.controller.form.UserForm;
import com.zup.orange.vaccines.controller.form.UserUpdateForm;
import com.zup.orange.vaccines.model.User;

public interface UserService {
	
	public List<UserDto> getUsers();
	
	public User getUserByCpf(String cpf);

	public User addNewUser(UserForm userForm);

	public User updateUser(String cpf, UserUpdateForm form);

	public void deleteUser(String cpf);

}
