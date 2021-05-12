package com.zup.orange.vaccines.vaximmunization;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.orange.vaccines.user.User;

public class VaxImmunizationForm {

	@NotEmpty @NotNull
	private String vaccineName;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vaccinationDate;
//	@NotEmpty @NotNull
//	private Long userId;
	
	private User user;
	
	public String getVaccineName() {
		return vaccineName;
	}
	
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	
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

	public VaxImmunization convert() {
		return new VaxImmunization(vaccineName, vaccinationDate, user);
	}
	
}
