package com.zup.orange.vaccines.controller.dto;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.zup.orange.vaccines.model.Vaccination;

public class VaccinationDto {

	private Long id;
	private String vaccineName;
	private String userEmail;
	private Timestamp vaccinationDate;
	
	private Long userId;

	public VaccinationDto(Vaccination vaccination) {
		this.id = vaccination.getId();
		this.vaccineName = vaccination.getVaccineName();
		this.userEmail = vaccination.getUserEmail();
		this.vaccinationDate = vaccination.getVaccinationDate();
		this.userId = vaccination.getUserId();
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public Timestamp getVaccinationDate() {
		return vaccinationDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setVaccinationDate(Timestamp vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public static List<VaccinationDto> convert(List<Vaccination> vaccinations) {
		return vaccinations.stream().map(VaccinationDto::new).collect(Collectors.toList());
	}

}
