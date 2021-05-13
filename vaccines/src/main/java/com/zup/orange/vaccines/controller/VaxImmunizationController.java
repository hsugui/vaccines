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

import com.zup.orange.vaccines.controller.dto.UserDto;
import com.zup.orange.vaccines.controller.dto.VaxImmunizationDto;
import com.zup.orange.vaccines.controller.form.VaccineForm;
import com.zup.orange.vaccines.controller.form.VaxImmunizationForm;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.model.VaxImmunization;
import com.zup.orange.vaccines.repository.UserRepository;
import com.zup.orange.vaccines.repository.VaccineRepository;
import com.zup.orange.vaccines.service.UserService;
import com.zup.orange.vaccines.service.VaccineService;
import com.zup.orange.vaccines.service.VaxImmunizationService;

@RestController
@RequestMapping("/user-vaccination")
public class VaxImmunizationController {

//	@Autowired
//	private UserRepository userRepository;
//	@Autowired
//	private VaccinationRepository vaccinationRepository;
//	@Autowired
//	private VaxImmunizationRepository vaxImmunizationRepository;
	
	
	private UserService userService;
	private VaccineService vaccineService;
	private VaxImmunizationService vaxImmunizationService;
	
//	@Autowired
//	public VaxImmunizationController(UserService userService, VaccinationService vaccinationService) {
//		this.userService = userService;
//		this.vaccinationService = vaccinationService;
//	}
//	
//	@Autowired
//	public VaxImmunizationController(VaxImmunizationService vaxImmunizationService, VaccinationService vaccinationService) {
//		this.vaxImmunizationService = vaxImmunizationService;
//		this.vaccinationService = vaccinationService;
//	}
	
	@Autowired
	public VaxImmunizationController(VaxImmunizationService vaxImmunizationService, UserService userService) {
		this.vaxImmunizationService = vaxImmunizationService;
		this.userService = userService;
	}
  
	@GetMapping
	public List<VaxImmunizationDto> list() {
		return vaxImmunizationService.getVaxImmunization();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VaxImmunization register(@RequestBody @Valid VaxImmunizationForm vaxImmunizationForm) {
		return vaxImmunizationService.addNewVaxImmunization(vaxImmunizationForm);
	}
	
}
