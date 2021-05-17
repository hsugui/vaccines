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

import com.zup.orange.vaccines.controller.dto.VaccineDto;
import com.zup.orange.vaccines.controller.form.VaccineForm;
import com.zup.orange.vaccines.controller.form.VaccineUpdateForm;
import com.zup.orange.vaccines.implementation.VaccineServiceImpl;
import com.zup.orange.vaccines.model.Vaccine;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

	private final VaccineServiceImpl vaccineServiceImpl;
	
	@Autowired
	public VaccineController(VaccineServiceImpl vaccineServiceImpl) {
		this.vaccineServiceImpl = vaccineServiceImpl;
	}
	
	@GetMapping
	public List<VaccineDto> listVaccines() {
		return vaccineServiceImpl.getVaccines();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vaccine registerVaccine(@RequestBody @Valid VaccineForm vaccineForm) {
		return vaccineServiceImpl.addNewVax(vaccineForm);
	}
	
	@PutMapping("/{id}")
	public Vaccine updateVaccine(@PathVariable Long id, @RequestBody @Valid VaccineUpdateForm vaccineForm) {
		return vaccineServiceImpl.updateVaccine(id, vaccineForm);
	}

	@DeleteMapping("/{id}")
	public void deleteVaccine(@PathVariable("id") Long id) {
		vaccineServiceImpl.deleteVaccine(id);
	}
	
}
