package com.zup.orange.vaccines.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zup.orange.vaccines.controller.dto.VaccinationDto;
import com.zup.orange.vaccines.controller.form.VaccinationForm;
import com.zup.orange.vaccines.controller.form.VaccinationUpdateForm;
import com.zup.orange.vaccines.model.Vaccination;
import com.zup.orange.vaccines.repository.VaccinationRepository;

@Service
public class VaccinationService {

	private final VaccinationRepository vaccinationRepository;
	
	@Autowired
	public VaccinationService(VaccinationRepository vaccinationRepository) {
		this.vaccinationRepository = vaccinationRepository;
	}
	
	public List<VaccinationDto> getVaccinations() {
		List<Vaccination> vaccinations = vaccinationRepository.findAll();
		return VaccinationDto.convert(vaccinations);
	}

	public Vaccination addNewVax(VaccinationForm vaccinationForm) {
		Vaccination vaccination = vaccinationForm.convert();
		return vaccinationRepository.save(vaccination);
	}
	
	@Transactional
	public Vaccination updateVaccination(@PathVariable Long id, @RequestBody @Valid VaccinationUpdateForm form) {
		Optional<Vaccination> vaccinationOptional = vaccinationRepository.findById(id);
		if (vaccinationOptional.isPresent())	{
			return form.updateVaccination(id, vaccinationRepository);
		}
		throw new IllegalStateException("vaccination with id " + id + " does not exist");
	}

	public void deleteVaccination(Long id) {
		boolean exists = vaccinationRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("vaccination with id " + id + " does not exist");
		}
		vaccinationRepository.deleteById(id);
	}
	
}
