package com.zup.orange.vaccines.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zup.orange.vaccines.controller.dto.VaccinationDto;
import com.zup.orange.vaccines.controller.form.VaccinationForm;
import com.zup.orange.vaccines.model.Vaccination;
import com.zup.orange.vaccines.repository.VaccinationRepository;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

	@Autowired
	private VaccinationRepository vaccinationRepository;
	
	@GetMapping
	public List<VaccinationDto> list() {
		List<Vaccination> vaccinations = vaccinationRepository.findAll();
		return VaccinationDto.convert(vaccinations);
	}
	
	@PostMapping
	public ResponseEntity<VaccinationDto> register(@RequestBody @Valid VaccinationForm vaccinationForm, UriComponentsBuilder uriComponentsBuilder) {
		Vaccination vaccination = vaccinationForm.convert();
		vaccinationRepository.save(vaccination);
		
		URI uri = uriComponentsBuilder.path("/vaccination").buildAndExpand(vaccination).toUri();
		return ResponseEntity.created(uri).body(new VaccinationDto(vaccination));
	}
	
}
