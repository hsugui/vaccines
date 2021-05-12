package com.zup.orange.vaccines.vaccine;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VaccineForm {

	@NotEmpty @NotNull
	private String vaccineName;

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
