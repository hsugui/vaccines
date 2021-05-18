package com.zup.orange.vaccines.service;

import java.util.List;

import com.zup.orange.vaccines.controller.dto.VaxImmunizationDto;
import com.zup.orange.vaccines.controller.form.VaxImmuUpdateForm;
import com.zup.orange.vaccines.controller.form.VaxImmunizationForm;
import com.zup.orange.vaccines.model.VaxImmunization;

public interface VaxImmunizationService {

	public List<VaxImmunizationDto> listAllImmunizations();
	
	public VaxImmunization getImmunizationById(Long id);
	
	public VaxImmunization addNewImmunization(VaxImmunizationForm vaxImmunizationForm);
	
	public VaxImmunization updateVaxImmunization(Long id, VaxImmuUpdateForm form);

	public void deleteVaxImmunization(Long id);
	
}
