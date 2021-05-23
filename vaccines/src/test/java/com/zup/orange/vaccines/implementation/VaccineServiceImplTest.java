package com.zup.orange.vaccines.implementation;

import static org.junit.jupiter.api.Assertions.fail;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zup.orange.vaccines.controller.form.VaccineForm;
import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.repository.VaccineRepository;

@ExtendWith(MockitoExtension.class)
public class VaccineServiceImplTest {
	
	@Mock
	private VaccineRepository vaccineRepository;
	private VaccineServiceImpl underTest;
	
	@BeforeEach
	void setUp() {
		this.underTest = new VaccineServiceImpl(vaccineRepository);
	}

	@Test
	void canGetAllVaccines() {
		// when
		underTest.getVaccines();
		// then
		Mockito.verify(vaccineRepository).findAll();
	}
	
	private Vaccine vaccineForTest() {
		Vaccine vaccine = new Vaccine("VAC1");
		vaccine.setId(1L);
		return vaccine;
	}

	@Test
	void canGetAVaccineByItsId() {
		Vaccine vaccine = vaccineForTest();
		
		//Mockito.when(vaccineRepository.findById(vaccine.getId())).
		
		//underTest.getVaccineById(vaccine.getId());
		
		Mockito.verify(vaccineRepository).findById(vaccine.getId());
	}

	@Test
	void canAddNewVaccine() {
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
//	void canDeleteVaccineByItsId() {
//		List<Vaccine> vaccines = vaccinesListForTest();
//		Long id = vaccines.get(0).getId();
//		
//		//Mockito.when(vaccineRepository.deleteById(id));
//		
//		underTest.deleteVaccine(vaccines.get(0).getId());
//		Mockito.verify(vaccineRepository, Mockito.times(1)).delete(vaccines.get(0));
		
//		Vaccine vaccine = new Vaccine("VAC1");
//		vaccine.setId(1L);
//		underTest.deleteVaccine(vaccine.getId());
//		Mockito.verify(vaccineRepository, Mockito.times(1)).delete(vaccine);
		
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
