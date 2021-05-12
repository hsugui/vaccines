package com.zup.orange.vaccines.vaximmunization;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.orange.vaccines.user.User;

public class VaxImmunizationDto {
	
	private Long id;
	private String vaccineName;
	private LocalDate vaccinationDate;
	private User user;
//	private Long userId;
	
	public VaxImmunizationDto(VaxImmunization vaxImmunization) {
		this.id = vaxImmunization.getId();
		this.vaccineName = vaxImmunization.getVaccineName();
		this.vaccinationDate = vaxImmunization.getVaccinationDate();
//		this.userId = vaxImmunization.getUserId();
		this.user = vaxImmunization.getUser();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public LocalDate getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(LocalDate vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}

	public static List<VaxImmunizationDto> convert(List<VaxImmunization> vaxImmunizations) {
		return vaxImmunizations.stream().map(VaxImmunizationDto::new).collect(Collectors.toList());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
