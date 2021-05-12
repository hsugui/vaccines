package com.zup.orange.vaccines.vaccine;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VaccineUpdateForm {
	
	@NotEmpty @NotNull
	private String vaccineName;	

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Vaccine updateVaccine(Long id, VaccineRepository vaccineRepository) {
		Vaccine vaccine = vaccineRepository.getOne(id);
		vaccine.setVaccineName(this.vaccineName);
		return vaccine;
	}

}
