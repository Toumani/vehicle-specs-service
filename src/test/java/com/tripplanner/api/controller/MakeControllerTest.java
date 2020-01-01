package com.tripplanner.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tripplanner.api.dto.MakeDto;
import com.tripplanner.api.dto.ModelDto;
import com.tripplanner.api.entity.Make;
import com.tripplanner.api.entity.Model;
import com.tripplanner.api.service.MakeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(MakeController.class)
class MakeControllerTest {

	@MockBean
	MakeService makeService;

	@Autowired
	private MockMvc mvc;

	// This object will be magically initialized by the initFields method below.
	private JacksonTester<List<MakeDto>> makeListJson;
	private JacksonTester<MakeDto> makeJson;

	@BeforeEach
	void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	void getAllMakes() throws Exception {
		// given
		List<Make> makes = new ArrayList<>();
		makes.add(new Make());
		given(makeService.getAllMakes())
				.willReturn(makes);

		// when
		MockHttpServletResponse response = mvc.perform(
				get("/make/all")
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		List<MakeDto> actualResponse = makeListJson.parse(response.getContentAsString()).getObject();
		assertThat(actualResponse.size()).isEqualTo(makes.size());
	}

	@Test
	void getMake() throws Exception {
		// given
		final String makeName = "Hyundai";
		final List<Model> hyundaiModels = new ArrayList<>();
		final String[] hyundaiModelNames = {"Grand i10", "i20", "Accent", "i30", "Creta", "Tucson", "IONIQ", "i40", "Santa Fe"};
		for (String modelName : hyundaiModelNames) {
			hyundaiModels.add(new Model(modelName, new Make()));
		}
		Make hyundai = new Make(makeName, hyundaiModels);

		given(makeService.getMake(makeName))
				.willReturn(hyundai);

		// when
		MockHttpServletResponse response = mvc.perform(
				get("/cars/" + makeName)
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		// then
		MakeDto actualResponse = makeJson.parse(response.getContentAsString()).getObject();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(actualResponse.getModels().size()).isEqualTo(hyundaiModelNames.length);
		assertThat(actualResponse.getModels()
				.stream()
				.map(ModelDto::getName)
				.collect(Collectors.toList())
				.containsAll(Arrays.asList(hyundaiModelNames)))
		.isTrue();
	}
}
