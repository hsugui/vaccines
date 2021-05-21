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
		underTest = new VaccineServiceImpl(vaccineRepository);
	}

	@Test
	void canGetAllVaccines() {
		// when
		underTest.getVaccines();
		// then
		Mockito.verify(vaccineRepository).findAll();
	}

	@Test
	@Disabled
	void testGetVaccineById() {
		fail("Not yet implemented");
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

	@Test
	@Disabled
	void testDeleteVaccine() {
		fail("Not yet implemented");
	}

}
