package com.tripplanner.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tripplanner.api.constant.FuelType;
import com.tripplanner.api.dto.ModelDto;
import com.tripplanner.api.dto.VersionDto;
import com.tripplanner.api.entity.Engine;
import com.tripplanner.api.entity.Make;
import com.tripplanner.api.entity.Model;
import com.tripplanner.api.entity.Version;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ModelController.class)
class ModelControllerTest {

	@MockBean
	private ModelService modelService;

	@Autowired
	private MockMvc mvc;

	private JacksonTester<List<ModelDto>> modelListJson;
	private JacksonTester<ModelDto> modelJson;

	private List<Model> hyundaiModels;

	private static final String REQUESTED_MAKE_NAME = "Hyundai";
	private static final String REQUESTED_MODEL_NAME = "Accent";
	private static final String[] ACCENT_VERSION_TRIMS = {"Attractive", "BVA Attractive", "Inventive", "BVA Inventive"};

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
		Mockito.lenient().when(modelService.getModel(REQUESTED_MAKE_NAME, REQUESTED_MODEL_NAME)).thenReturn(
				new Model("Accent", Arrays.asList(
						new Version(2019, "Attractive", 46, new Engine("1.6 CRDi 128", FuelType.DIESEL)),
						new Version(2019, "BVA Attractive", 54, new Engine("1.6 CRDi 128", FuelType.DIESEL)),
						new Version(2019, "Inventive", 46,new Engine("1.6 CRDi 128", FuelType.DIESEL)),
						new Version(2019, "BVA Inventive", 54, new Engine("1.6 CRDi 128", FuelType.DIESEL))
				))
		);
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
		List<ModelDto> actualResponse = modelListJson.parse(response.getContentAsString()).getObject();
		assertThat(actualResponse.size()).isEqualTo(hyundaiModels.size());
	}

	@Test
	void getModel() throws Exception {
		// when
		MockHttpServletResponse response = mvc.perform(
				get("/cars/" + REQUESTED_MAKE_NAME + "/" + REQUESTED_MODEL_NAME)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		ModelDto actualResponse = modelJson.parse(response.getContentAsString()).getObject();
		assertThat(actualResponse.getName()).isEqualTo(REQUESTED_MODEL_NAME);
		assertThat(actualResponse.getVersions()
				.stream()
				.map(VersionDto::getTrim)
				.collect(Collectors.toList())
				.containsAll(Arrays.asList(ACCENT_VERSION_TRIMS))
		).isTrue();
	}
}
