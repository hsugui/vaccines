package com.zup.orange.vaccines.vaccine;

import java.util.List;
import java.util.stream.Collectors;

public class VaccineDto {

	private Long id;
	private String vaccineName;

	public VaccineDto(Vaccine vaccine) {
		this.id = vaccine.getId();
		this.vaccineName = vaccine.getVaccineName();
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

	public static List<VaccineDto> convert(List<Vaccine> vaccines) {
		return vaccines.stream().map(VaccineDto::new).collect(Collectors.toList());
	}

}
