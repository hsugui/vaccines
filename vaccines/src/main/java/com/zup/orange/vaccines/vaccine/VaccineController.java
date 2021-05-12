package com.zup.orange.vaccines.vaccine;

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

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

	private final VaccineService vaccineService;
	
	@Autowired
	public VaccineController(VaccineService vaccineService) {
		this.vaccineService = vaccineService;
	}
	
	@GetMapping
	public List<VaccineDto> listVaccines() {
		return vaccineService.getVaccines();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vaccine registerVaccine(@RequestBody @Valid VaccineForm vaccineForm) {
		return vaccineService.addNewVax(vaccineForm);
	}
	
	@PutMapping("/{id}")
	public Vaccine updateVaccine(@PathVariable Long id, @RequestBody @Valid VaccineUpdateForm vaccineForm) {
		return vaccineService.updateVaccine(id, vaccineForm);
	}

	@DeleteMapping("/{id}")
	public void deleteVaccine(@PathVariable("id") Long id) {
		vaccineService.deleteVaccine(id);
	}
	
}
