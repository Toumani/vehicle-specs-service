package com.tripplanner.api.service;

import com.tripplanner.api.entity.Make;
import com.tripplanner.api.entity.Model;
import com.tripplanner.api.repository.MakeRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MakeServiceTest {

	private MakeServiceImpl makeService;
	private final static String REQUESTED_MAKE_NAME = "Hyundai";
	private final String[] hyundaiModelNames = {"Grand i10", "i20", "Accent", "i30", "Creta", "Tucson", "IONIQ", "i40", "Santa Fe"};

	@BeforeEach
	void setup(@Mock MakeRepository makeRepository) {
		makeService = new MakeServiceImpl(makeRepository);

		// given
		List<Make> repositoryMakes = new ArrayList<>();
		repositoryMakes.add(new Make("Alpha Romeo"));
		repositoryMakes.add(new Make("Bentley"));
		repositoryMakes.add(new Make("Chevrolet"));
		repositoryMakes.add(new Make("Dacia"));

		final String makeName = "Hyundai";
		final List<Model> hyundaiModels = new ArrayList<>();
		for (String modelName : hyundaiModelNames) {
			hyundaiModels.add(new Model(modelName, new Make()));
		}
		Make hyundai = new Make(makeName, hyundaiModels);

		Mockito.lenient().when(makeRepository.findAll()).thenReturn(repositoryMakes);
		Mockito.lenient().when(makeRepository.findByName(REQUESTED_MAKE_NAME)).thenReturn(hyundai);
	}

	@Test
	void getAllMakes() {
		// when
		List<Make> serviceMakes = makeService.getAllMakes();

		// then
		assertThat(serviceMakes.size()).isEqualTo(4);
	}

	@Test
	void getMake() {
		// when
		Make serviceMakes = makeService.getMake(REQUESTED_MAKE_NAME);

		// then
		// Check number of result
		assertThat(serviceMakes.getModels().size()).isEqualTo(hyundaiModelNames.length);
		// Check every model belongs to given make
		for (Model hyundaiModels : serviceMakes.getModels()) {
			assertThat(hyundaiModels.getMake().getName()).isEqualTo(REQUESTED_MAKE_NAME);
		}
		// Check every model is present
		assertThat(serviceMakes.getModels()
				.stream()
				.map(Model::getName)
				.collect(Collectors.toList())
				.containsAll(Arrays.asList(hyundaiModelNames))
		).isTrue();
	}
}
