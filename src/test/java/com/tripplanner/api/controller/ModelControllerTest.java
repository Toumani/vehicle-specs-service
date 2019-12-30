package com.tripplanner.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tripplanner.api.entity.Make;
import com.tripplanner.api.entity.Model;
import com.tripplanner.api.service.ModelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ModelController.class)
class ModelControllerTest {

	@MockBean
	private ModelService modelService;

	@Autowired
	private MockMvc mvc;

	private JacksonTester<List<Model>> json;

	private List<Model> hyundaiModels;

	private static final String REQUESTED_MAKE_NAME = "Hyundai";

	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		Make hyundai = new Make(REQUESTED_MAKE_NAME);

		// given
		hyundaiModels = new ArrayList<>();
		hyundaiModels.add(new Model("i10", hyundai));
		hyundaiModels.add(new Model("i20", hyundai));
		hyundaiModels.add(new Model("Accent", hyundai));
		hyundaiModels.add(new Model("i30", hyundai));
		hyundaiModels.add(new Model("i40", hyundai));
		hyundaiModels.add(new Model("Creta", hyundai));
		hyundaiModels.add(new Model("ix35", hyundai));
		hyundaiModels.add(new Model("Santa Fe", hyundai));
		hyundaiModels.add(new Model("Sonata", hyundai));
		Mockito.lenient().when(modelService.getModelsOfMake(REQUESTED_MAKE_NAME)).thenReturn(hyundaiModels);
	}

	@Test
	void getModelsOfMake() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
				get("/model/" + REQUESTED_MAKE_NAME)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString())
				.isEqualTo(json.write(hyundaiModels).getJson());
	}
}
