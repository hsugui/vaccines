package com.zup.orange.vaccines.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Override
	public List<VaccineDto> getVaccines() {
		List<Vaccine> vaccines = vaccineRepository.findAll();
		return VaccineDto.convert(vaccines);
	}
	
	@Override
	public Vaccine getVaccineById(Long id) {
		Optional<Vaccine> vaccine = vaccineRepository.findById(id);
		if (vaccine.isPresent()) {
			return vaccine.get();
		}
		throw new IllegalStateException("vaccine with id " + id + " does not exist");
	}

	@Override
	@Transactional
	public Vaccine addNewVax(VaccineForm vaccineForm) {
		Vaccine vaccine = vaccineForm.convert();
		return vaccineRepository.save(vaccine);
	}
	
	@Override
	@Transactional
	public Vaccine updateVaccine(Long id, VaccineUpdateForm form) {
		Optional<Vaccine> vaccineOptional = vaccineRepository.findById(id);
		if (vaccineOptional.isPresent())	{
			return form.updateVaccine(id, vaccineRepository);
		}
		throw new IllegalStateException("vaccine with id " + id + " does not exist");
	}

	@Override
	public void deleteVaccine(Long id) {
		boolean exists = vaccineRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("vaccine with id " + id + " does not exist");
		}
		vaccineRepository.deleteById(id);
	}

	@Override
	public List<Vaccine> findPaginated(Pageable pageable) {
		Page<Vaccine> page = vaccineRepository.findAll(pageable);
		return page.getContent();
	}
	
}
