package com.zup.orange.vaccines.user;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

public class UserUpdateForm {

	@NotEmpty @NotNull
	private String name;
	@Email @NotNull
	private String email;
	@CPF
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public User update(Long id, UserRepository userRepository) {
		User user = userRepository.getOne(id);
		
		user.setName(this.name);
		user.setEmail(this.email);
		user.setCpf(this.cpf);
		user.setBirthDate(this.birthDate);
		
		return user;
	}

}
