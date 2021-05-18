package com.zup.orange.vaccines.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.model.VaxImmunization;

public class VaccineDto {

	private Long id;
	private String vaccineName;
	
	private List<VaxImmunization> vaxImmunizations;

	public VaccineDto(Vaccine vaccine) {
		this.id = vaccine.getId();
		this.vaccineName = vaccine.getVaccineName();
		this.vaxImmunizations = vaccine.getVaxImmunizations();
	}

	public Long getId() {
		return id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public List<VaxImmunization> getVaxImmunization() {
		return vaxImmunizations;
	}

	public void setVaxImmunization(List<VaxImmunization> vaxImmunizations) {
		this.vaxImmunizations = vaxImmunizations;
	}

	public static List<VaccineDto> convert(List<Vaccine> vaccines) {
		return vaccines.stream().map(VaccineDto::new).collect(Collectors.toList());
	}

}
