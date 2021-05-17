package com.zup.orange.vaccines.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zup.orange.vaccines.controller.dto.VaccineDto;
import com.zup.orange.vaccines.controller.form.VaccineForm;
import com.zup.orange.vaccines.controller.form.VaccineUpdateForm;
import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.repository.VaccineRepository;
import com.zup.orange.vaccines.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {

	private final VaccineRepository vaccineRepository;
	
	@Autowired
	public VaccineServiceImpl(VaccineRepository vaccineRepository) {
		this.vaccineRepository = vaccineRepository;
	}
	
	public List<VaccineDto> getVaccines() {
		List<Vaccine> vaccines = vaccineRepository.findAll();
		return VaccineDto.convert(vaccines);
	}

	@Transactional
	public Vaccine addNewVax(VaccineForm vaccineForm) {
		Vaccine vaccine = vaccineForm.convert();
		return vaccineRepository.save(vaccine);
	}
	
	@Transactional
	public Vaccine updateVaccine(Long id, VaccineUpdateForm form) {
		Optional<Vaccine> vaccineOptional = vaccineRepository.findById(id);
		if (vaccineOptional.isPresent())	{
			return form.updateVaccine(id, vaccineRepository);
		}
		throw new IllegalStateException("vaccine with id " + id + " does not exist");
	}

	public void deleteVaccine(Long id) {
		boolean exists = vaccineRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("vaccine with id " + id + " does not exist");
		}
		vaccineRepository.deleteById(id);
	}
	
}
