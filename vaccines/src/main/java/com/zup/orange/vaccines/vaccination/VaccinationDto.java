package com.zup.orange.vaccines.vaccination;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VaccinationDto {

	private Long id;
	private String vaccineName;
	private String userEmail;
	private LocalDate vaccinationDate;

	public VaccinationDto(Vaccination vaccination) {
		this.id = vaccination.getId();
		this.vaccineName = vaccination.getVaccineName();
		this.userEmail = vaccination.getUserEmail();
		this.vaccinationDate = vaccination.getVaccinationDate();
	}

	public Long getId() {
		return id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public LocalDate getVaccinationDate() {
		return vaccinationDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setVaccinationDate(LocalDate vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public static List<VaccinationDto> convert(List<Vaccination> vaccinations) {
		return vaccinations.stream().map(VaccinationDto::new).collect(Collectors.toList());
	}

}
