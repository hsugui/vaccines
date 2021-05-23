package com.zup.orange.vaccines.controller.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.model.VaxImmunization;

public class VaccineForm {

	@NotEmpty @NotNull
	private String vaccineName;
	
	//private List<VaxImmunization> vaxImmunizations;
	
	public VaccineForm() {
	}

	public VaccineForm(String vaccineName) {
		this.vaccineName = vaccineName;
	}

//	public List<VaxImmunization> getVaxImmunizations() {
//		return vaxImmunizations;
//	}
//
//	public void setVaxImmunizations(List<VaxImmunization> vaxImmunizations) {
//		this.vaxImmunizations = vaxImmunizations;
//	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Vaccine convert() {
		return new Vaccine(vaccineName);
	}

}
