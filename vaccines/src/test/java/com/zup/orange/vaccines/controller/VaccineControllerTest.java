package com.zup.orange.vaccines.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.zup.orange.vaccines.controller.dto.VaccineDto;
import com.zup.orange.vaccines.implementation.VaccineServiceImpl;
import com.zup.orange.vaccines.model.Vaccine;
import com.zup.orange.vaccines.repository.VaccineRepository;
import com.zup.orange.vaccines.service.VaccineService;

@WebMvcTest(value = VaccineController.class)
@ExtendWith(SpringExtension.class)
//@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class VaccineControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private VaccineServiceImpl vaccineServiceImpl;
	
	@MockBean
	private VaccineService vaccineService;
	
	@MockBean
	private VaccineRepository vaccineRepository;

	@Test
	public void shouldReturnAllVaccines() throws Exception {
		List<VaccineDto> vaccines = new ArrayList<>();
		vaccines.add(new VaccineDto("VAC1"));
		vaccines.add(new VaccineDto("VAC2"));
		vaccines.add(new VaccineDto("VAC3"));
		
		Mockito.when(vaccineServiceImpl.getVaccines()).thenReturn(vaccines);
		
		URI uri = new URI("api/v1/immunizations");
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
