package com.zup.orange.vaccines.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zup.orange.vaccines.controller.dto.VaxImmunizationDto;
import com.zup.orange.vaccines.controller.form.VaxImmunizationForm;
import com.zup.orange.vaccines.implementation.VaxImmunizationServiceImpl;
import com.zup.orange.vaccines.model.VaxImmunization;

@RestController
@RequestMapping("/user-vaccination")
public class VaxImmunizationController {

	private VaxImmunizationServiceImpl vaxImmunizationServiceImpl;
	
	@Autowired
	public VaxImmunizationController(VaxImmunizationServiceImpl vaxImmunizationServiceImpl) {
		this.vaxImmunizationServiceImpl = vaxImmunizationServiceImpl;
	}
	
	@GetMapping
	public List<VaxImmunizationDto> getAllImmunizations() {
		return vaxImmunizationServiceImpl.listAllImmunizations();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VaxImmunization saveImmunization(@RequestBody @Valid VaxImmunizationForm vaxImmunizationForm) {
		return vaxImmunizationServiceImpl.addNewImmunization(vaxImmunizationForm);
	}
	
}
