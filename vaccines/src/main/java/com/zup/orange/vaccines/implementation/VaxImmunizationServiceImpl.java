package com.zup.orange.vaccines.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zup.orange.vaccines.controller.dto.VaxImmunizationDto;
import com.zup.orange.vaccines.controller.form.VaxImmuUpdateForm;
import com.zup.orange.vaccines.controller.form.VaxImmunizationForm;
import com.zup.orange.vaccines.model.VaxImmunization;
import com.zup.orange.vaccines.repository.VaxImmunizationRepository;
import com.zup.orange.vaccines.service.VaxImmunizationService;

@Service
public class VaxImmunizationServiceImpl implements VaxImmunizationService {
	
	private final VaxImmunizationRepository vaxImmunizationRepository;
	
	@Autowired
	public VaxImmunizationServiceImpl(VaxImmunizationRepository vaxImmunizationRepository) {
		this.vaxImmunizationRepository = vaxImmunizationRepository;
	}
	
	@Override
	public List<VaxImmunizationDto> listAllImmunizations() {
		List<VaxImmunization> vaxImmunizations = vaxImmunizationRepository.findAll();
		return VaxImmunizationDto.convert(vaxImmunizations);
	}
	
	@Override
	public VaxImmunization getImmunizationById(Long id) {
		Optional<VaxImmunization> vaxImmunization = vaxImmunizationRepository.findById(id);
		if (vaxImmunization.isPresent()) {
			return vaxImmunization.get();
		}
		throw new IllegalStateException("immunization with id " + id + " does not exist");
	}

	@Override
	public VaxImmunization addNewImmunization(VaxImmunizationForm vaxImmunizationForm) {
		VaxImmunization vaxImmunization = vaxImmunizationForm.convert();
		return vaxImmunizationRepository.save(vaxImmunization);
	}

	@Override
	@Transactional
	public VaxImmunization updateVaxImmunization(Long id, VaxImmuUpdateForm form) {
		Optional<VaxImmunization> vaxImmuOptional = vaxImmunizationRepository.findById(id);
		if (vaxImmuOptional.isPresent()) {
			return form.updateVaxImmu(id, vaxImmunizationRepository);
		}
		throw new IllegalStateException("immunization with id " + id + " does not exist");
	}

	@Override
	public void deleteVaxImmunization(Long id) {
		boolean exists = vaxImmunizationRepository.existsById(id);
		if (!exists) {
			throw new IllegalStateException("immunization with id " + id + " does not exist");
		}
		vaxImmunizationRepository.deleteById(id);
	}
	
}
