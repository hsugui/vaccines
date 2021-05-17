package com.zup.orange.vaccines.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.model.VaxImmunization;

public class VaxImmunizationDto {
	
	private Long id;
	private LocalDate vaccinationDate;
	private User user;
	private Vaccine vaccine;
	
	public VaxImmunizationDto(VaxImmunization vaxImmunization) {
		this.id = vaxImmunization.getId();
		this.vaccinationDate = vaxImmunization.getVaccinationDate();
		this.user = vaxImmunization.getUser();
		this.vaccine = vaxImmunization.getVaccine();
	}
	
//	public VaxImmunizationDto(String userCpf, String vaccineName, LocalDate vaccinationDate) {
//		userCpf = user.getCpf();
//		vaccineName = vaccine.getVaccineName();
//		this.vaccinationDate = vaccinationDate;
//	}
	
	public String getUserCpf() {
		return user.getCpf();
	}
	
	public void setUserCpf(String userCpf) {
		userCpf = user.getCpf();
	}

	public String getVaccineName() {
		return vaccine.getVaccineName();
	}

	public void setVaccineName(String vaccineName) {
		vaccineName = vaccine.getVaccineName();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public LocalDate getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(LocalDate vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	
	public static List<VaxImmunizationDto> convert(List<VaxImmunization> vaxImmunizations) {
		return vaxImmunizations.stream().map(VaxImmunizationDto::new).collect(Collectors.toList());
	}

}
