package com.zup.orange.vaccines.controller.form;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.model.VaxImmunization;

public class UserForm {

	@NotEmpty @NotNull
	private String name;
	@Email @NotNull
	private String email;
	@CPF
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;

	private VaxImmunization vaxImmunization;
	
//	private List<VaxImmunization> vaxImmunizations;
//
//	public List<VaxImmunization> getVaxImmunizations() {
//		return vaxImmunizations;
//	}
//
//	public void setVaxImmunizations(List<VaxImmunization> vaxImmunizations) {
//		this.vaxImmunizations = vaxImmunizations;
//	}

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

	public User convert() {
		return new User(name, email, cpf, birthDate, vaxImmunization);
	}

}
