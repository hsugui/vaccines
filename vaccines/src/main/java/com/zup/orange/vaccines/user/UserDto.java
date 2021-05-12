package com.zup.orange.vaccines.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.orange.vaccines.vaccination.Vaccination;

public class UserDto {

	private Long id;
	private String name;
	private String email;
	private String cpf;
	private LocalDate birthDate;
	private Set<Vaccination> vaccinations;

	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
		this.birthDate = user.getBirthDate();
		this.vaccinations = user.getVaccinations();
	}

	public Set<Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(Set<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public static List<UserDto> convert(List<User> users) {
		return users.stream().map(UserDto::new).collect(Collectors.toList());
	}

}
