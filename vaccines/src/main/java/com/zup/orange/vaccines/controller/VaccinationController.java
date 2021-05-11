package com.zup.orange.vaccines.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zup.orange.vaccines.controller.dto.VaccinationDto;
import com.zup.orange.vaccines.controller.form.VaccinationForm;
import com.zup.orange.vaccines.controller.form.VaccinationUpdateForm;
import com.zup.orange.vaccines.model.Vaccination;
import com.zup.orange.vaccines.service.VaccinationService;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

	private final VaccinationService vaccinationService;
	
	@Autowired
	public VaccinationController(VaccinationService vaccinationService) {
		this.vaccinationService = vaccinationService;
	}
	
	@GetMapping
	public List<VaccinationDto> listVaccinations() {
		return vaccinationService.getVaccinations();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vaccination registerVaccination(@RequestBody @Valid VaccinationForm vaccinationForm) {
		return vaccinationService.addNewVax(vaccinationForm);
	}
	
	@PutMapping("/{id}")
	public Vaccination updateVaccination(@PathVariable Long id, @RequestBody @Valid VaccinationUpdateForm vaccinationForm) {
		return vaccinationService.updateVaccination(id, vaccinationForm);
	}

	@DeleteMapping("/{id}")
	public void deleteVaccination(@PathVariable("id") Long id) {
		vaccinationService.deleteVaccination(id);
	}
	
}
