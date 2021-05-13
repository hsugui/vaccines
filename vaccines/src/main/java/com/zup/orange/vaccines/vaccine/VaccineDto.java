package com.zup.orange.vaccines.vaccine;

import java.util.List;
import java.util.stream.Collectors;

import com.zup.orange.vaccines.vaximmunization.VaxImmunization;

public class VaccineDto {

	private Long id;
	private String vaccineName;
	private VaxImmunization vaxImmunization;

	public VaccineDto(Vaccine vaccine) {
		this.id = vaccine.getId();
		this.vaccineName = vaccine.getVaccineName();
		this.vaxImmunization = vaccine.getVaxImmunization();
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

	public VaxImmunization getVaxImmunization() {
		return vaxImmunization;
	}

	public void setVaxImmunization(VaxImmunization vaxImmunization) {
		this.vaxImmunization = vaxImmunization;
	}

	public static List<VaccineDto> convert(List<Vaccine> vaccines) {
		return vaccines.stream().map(VaccineDto::new).collect(Collectors.toList());
	}

}
