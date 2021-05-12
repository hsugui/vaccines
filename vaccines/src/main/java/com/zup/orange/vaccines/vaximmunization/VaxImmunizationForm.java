package com.zup.orange.vaccines.vaximmunization;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.orange.vaccines.user.User;
import com.zup.orange.vaccines.vaccine.Vaccine;

public class VaxImmunizationForm {

	@NotEmpty @NotNull
	private String vaccineName;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vaccinationDate;
	
	private User user;
	private Vaccine vaccine;
	
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

	public VaxImmunization convert() {
		return new VaxImmunization(vaccineName, vaccinationDate, user, vaccine);
	}
	
}
