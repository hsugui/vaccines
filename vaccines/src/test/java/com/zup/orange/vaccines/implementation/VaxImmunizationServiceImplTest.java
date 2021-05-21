package com.zup.orange.vaccines.implementation;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zup.orange.vaccines.controller.form.VaxImmunizationForm;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.model.VaxImmunization;
import com.zup.orange.vaccines.repository.VaxImmunizationRepository;

@ExtendWith(MockitoExtension.class)
public class VaxImmunizationServiceImplTest {
	
	@Mock
	private VaxImmunizationRepository vaxImmunizationRepository;
	private VaxImmunizationServiceImpl underTest;

	@BeforeEach
	void setUp() throws Exception {
		underTest = new VaxImmunizationServiceImpl(vaxImmunizationRepository);
	}

	@Test
	void canListAllImmunizations() {
		// when
		underTest.listAllImmunizations();
		// then
		Mockito.verify(vaxImmunizationRepository).findAll();
	}

	@Test
	@Disabled
	void testGetImmunizationById() {
		fail("Not yet implemented");
	}

	@Test
	void canAddNewImmunization() {
		// given
		VaxImmunizationForm vaxImmuForm = new VaxImmunizationForm(LocalDate.now(), new User(), new Vaccine());
		VaxImmunization vaxImmunization = vaxImmuForm.convert();
		
		// when
		underTest.addNewImmunization(vaxImmuForm);
		
		// then
		ArgumentCaptor<VaxImmunization> vaxImmuArgumentCaptor = ArgumentCaptor.forClass(VaxImmunization.class);
		Mockito.verify(vaxImmunizationRepository).save(vaxImmuArgumentCaptor.capture());
		VaxImmunization capturedVaxImmunization = vaxImmuArgumentCaptor.getValue();
		AssertionsForClassTypes.assertThat(capturedVaxImmunization).isEqualTo(vaxImmunization);
	}

	@Test
	@Disabled
	void testUpdateVaxImmunization() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteVaxImmunization() {
		fail("Not yet implemented");
	}

}
