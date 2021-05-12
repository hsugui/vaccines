package com.zup.orange.vaccines.vaccination;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Transactional
	public Vaccination addNewVax(VaccinationForm vaccinationForm) {
		Vaccination vaccination = vaccinationForm.convert();
		return vaccinationRepository.save(vaccination);
	}
	
	@Transactional
	public Vaccination updateVaccination(Long id, VaccinationUpdateForm form) {
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
