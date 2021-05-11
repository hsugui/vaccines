package com.zup.orange.vaccines.controller.form;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.zup.orange.vaccines.model.Vaccination;

public class VaccinationForm {

	@NotEmpty
	private String vaccineName;
	@Email @NotEmpty
	private String userEmail;
	private Timestamp vaccinationDate;
	
	private Long userId;
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Timestamp getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Timestamp vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public Vaccination convert() {
		return new Vaccination(vaccineName, userEmail, vaccinationDate, userId);
	}

}
