package com.zup.orange.vaccines.uservaccination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.orange.vaccines.user.UserRepository;
import com.zup.orange.vaccines.vaccination.VaccinationRepository;

@Service
public class UserVaccinationService {

	private final UserRepository userRepository;
	private final VaccinationRepository vaccinationRepository;
	
	@Autowired
	public UserVaccinationService(UserRepository userRepository, VaccinationRepository vaccinationRepository) {
		this.userRepository = userRepository;
		this.vaccinationRepository = vaccinationRepository;
	}
	
	
	
}
