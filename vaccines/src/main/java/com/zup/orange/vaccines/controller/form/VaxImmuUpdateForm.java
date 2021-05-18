package com.zup.orange.vaccines.controller.form;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.model.VaxImmunization;
import com.zup.orange.vaccines.repository.VaxImmunizationRepository;

public class VaxImmuUpdateForm {

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vaccinationDate;
	
	private User user;
	private Vaccine vaccine;
	
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
	
	public VaxImmunization updateVaxImmu(Long id, VaxImmunizationRepository vaxImmunizationRepository) {
		VaxImmunization vaxImmunization = vaxImmunizationRepository.getOne(id);
		vaxImmunization.setUser(this.user); //setUserId?
		vaxImmunization.setVaccine(this.vaccine);
		vaxImmunization.setVaccinationDate(this.vaccinationDate);
		
		return vaxImmunization;
	}
	
}
