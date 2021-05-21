package com.zup.orange.vaccines.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zup.orange.vaccines.controller.dto.VaccineDto;
import com.zup.orange.vaccines.controller.form.VaccineForm;
import com.zup.orange.vaccines.controller.form.VaccineUpdateForm;
import com.zup.orange.vaccines.model.Vaccine;

public interface VaccineService {

	public List<VaccineDto> getVaccines();
	
	public Vaccine getVaccineById(Long id);

	public Vaccine addNewVax(VaccineForm vaccineForm);

	public Vaccine updateVaccine(Long id, VaccineUpdateForm form);

	public void deleteVaccine(Long id);
	
	public List<Vaccine> findPaginated(Pageable pageable);
	
}
