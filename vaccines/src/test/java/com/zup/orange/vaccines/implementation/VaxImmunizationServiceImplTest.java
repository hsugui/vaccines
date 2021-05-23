package com.zup.orange.vaccines.implementation;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.Optional;

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
	void shouldgetAllImmunizations() {
		// when
		underTest.listAllImmunizations();
		// then
		Mockito.verify(vaxImmunizationRepository).findAll();
	}

	@Test
	void shouldGetAnImmunizationByItsId() {
		// given
		VaxImmunization expectedVaxImmu = new VaxImmunization();
		expectedVaxImmu.setId(1L);
		// when
		Mockito.when(vaxImmunizationRepository.findById(1L)).thenReturn(Optional.of(expectedVaxImmu));
		VaxImmunization actualVaxImmu = underTest.getImmunizationById(1L);
		// then
		AssertionsForClassTypes.assertThat(actualVaxImmu.getId()).isEqualTo(expectedVaxImmu.getId());
	}

	@Test
	void shouldAddANewImmunization() {
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
	void shouldDeleteAnImmunizationByItsId() {
		VaxImmunization vaxImmu = new VaxImmunization();
		vaxImmu.setId(1L);
		
		Mockito.when(vaxImmunizationRepository.findById(1L)).thenReturn(Optional.of(vaxImmu));
		underTest.getImmunizationById(1L);
		vaxImmunizationRepository.deleteById(vaxImmu.getId());
		
		Mockito.verify(vaxImmunizationRepository, Mockito.times(1)).deleteById(1L);
	}

}
