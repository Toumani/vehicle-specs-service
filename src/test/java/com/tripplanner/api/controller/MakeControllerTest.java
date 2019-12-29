package com.tripplanner.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tripplanner.api.entity.Make;
import com.tripplanner.api.service.MakeService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(MakeController.class)
public class MakeControllerTest {

	@MockBean
	MakeService makeService;

	@Autowired
	private MockMvc mvc;

	// This object will be magically initialized by the initFields method below.
	private JacksonTester<List<Make>> json;

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void getAllMakes() throws Exception {
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
		assertThat(response.getContentAsString())
				.isEqualTo("[{\"name\":\"\"}]");
	}
}
