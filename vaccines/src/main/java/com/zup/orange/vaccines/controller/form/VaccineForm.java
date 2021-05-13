package com.zup.orange.vaccines.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.model.VaxImmunization;

public class VaccineForm {

	@NotEmpty @NotNull
	private String vaccineName;
	
	private VaxImmunization vaxImmunization;

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Vaccine convert() {
		return new Vaccine(vaccineName, vaxImmunization);
	}

}
