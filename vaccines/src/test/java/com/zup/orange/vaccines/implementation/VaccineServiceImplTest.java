package com.zup.orange.vaccines.implementation;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zup.orange.vaccines.controller.dto.VaccineDto;
import com.zup.orange.vaccines.controller.form.VaccineForm;
import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.repository.VaccineRepository;

@ExtendWith(MockitoExtension.class)
public class VaccineServiceImplTest {
	
	@Mock
	private VaccineRepository vaccineRepository;
	@InjectMocks
	private VaccineServiceImpl underTest;
	
	@BeforeEach
	void setUp() {
		this.underTest = new VaccineServiceImpl(vaccineRepository);
	}

	@Test
	void shouldGetAllVaccines() {
		// when
		underTest.getVaccines();
		// then
		Mockito.verify(vaccineRepository).findAll();
	}

	@Test
	void shouldGetAVaccineByItsId() {
		// given
		Vaccine expectedVaccine = new Vaccine();
		expectedVaccine.setId(1L);
		expectedVaccine.setVaccineName("VACNAME");
		// when
		Mockito.when(vaccineRepository.findById(1L)).thenReturn(Optional.of(expectedVaccine));
		Vaccine actualVaccine = underTest.getVaccineById(1L);
		// then
		AssertionsForClassTypes.assertThat(actualVaccine.getId()).isEqualTo(expectedVaccine.getId());
	}

	@Test
	void shouldAddANewVaccine() {
		// given
		VaccineForm vaccineForm = new VaccineForm("VAC");
		Vaccine vaccine = vaccineForm.convert();
		
		// when
		underTest.addNewVax(vaccineForm);
		
		// then
		ArgumentCaptor<Vaccine> vacArgumentCaptor = ArgumentCaptor.forClass(Vaccine.class);
		Mockito.verify(vaccineRepository).save(vacArgumentCaptor.capture());
		Vaccine capturedVaccine = vacArgumentCaptor.getValue();
		AssertionsForClassTypes.assertThat(capturedVaccine).isEqualTo(vaccine);
	}

	@Test
	@Disabled
	void testUpdateVaccine() {
		fail("Not yet implemented");
	}

//	@Test
//	@Disabled
//	void shouldDeleteAVaccineByItsId() {
		// given
//		Vaccine expectedVaccine = new Vaccine();
//		expectedVaccine.setId(1L);
//		expectedVaccine.setVaccineName("VACNAME");
		// when
//		Mockito.when(vaccineRepository.deleteById(1L)).thenReturn(Optional.of(expectedVaccine));
//		underTest.deleteVaccine(1L);
		// then
//		AssertionsForClassTypes.assertThat(actualVaccine.getId()).isEqualTo(expectedVaccine.getId());
//		
//		
//		List<Vaccine> vaccines = vaccinesListForTest();
//		Long id = vaccines.get(0).getId();
		
		//Mockito.when(vaccineRepository.deleteById(id));
		
//		underTest.deleteVaccine(vaccines.get(0).getId());
//		Mockito.verify(vaccineRepository, Mockito.times(1)).delete(vaccines.get(0));
//		
//		Vaccine vaccine = new Vaccine("VAC1");
//		vaccine.setId(1L);
//		underTest.deleteVaccine(vaccine.getId());
//		Mockito.verify(vaccineRepository, Mockito.times(1)).delete(vaccine);
//		
//		Long id = 1L;
//		Vaccine vaccine = new Vaccine();
//		vaccine.setId(id);
//		boolean existsBeforeDelete = vaccineRepository.findById(id).isPresent();
//		vaccineRepository.deleteById(id);
//		boolean dontExistAfterDelete = vaccineRepository.findById(id).isPresent();
//		
//		Assertions.assertTrue(existsBeforeDelete);
//		Assertions.assertFalse(dontExistAfterDelete);
//	}
	

}
