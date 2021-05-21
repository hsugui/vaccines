package com.zup.orange.vaccines.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.zup.orange.vaccines.model.VaxImmunization;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class VaxImmunizationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnTheListOfAllImmunizations() throws Exception {
		URI uri = new URI("api/v1/immunizations");
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
	}

//	@Test
//	public void shouldRegisterOneImmunizationWithDateUserIdAndVaccinationDate() throws Exception {
//		URI uri = new URI("api/v1/immunizations");
//		String json = "{\"user\":{\"id\":\"1\"},\"vaccine\":\"id\":\"5\"},\"vaccinationDate\":\"08/08/2008\"}";
//		
//		mockMvc.perform(MockMvcRequestBuilders
//				.post(uri)
//				.content(json)
//				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers
//						.status()
//						.isCreated());
//	}

}
