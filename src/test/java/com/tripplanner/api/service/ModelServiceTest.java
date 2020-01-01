package com.tripplanner.api.service;

import com.tripplanner.api.constant.FuelType;
import com.tripplanner.api.entity.Engine;
import com.tripplanner.api.entity.Make;
import com.tripplanner.api.entity.Model;
import com.tripplanner.api.entity.Version;
import com.tripplanner.api.repository.ModelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ModelServiceTest {

	private ModelServiceImpl modelService;

	private static final String REQUESTED_MAKE_NAME = "Hyundai";
	private static final String REQUESTED_MODEL_NAME = "Accent";

	@BeforeEach
	void setup(@Mock ModelRepository modelRepository) {
		modelService = new ModelServiceImpl(modelRepository);
		Make hyundai = new Make(REQUESTED_MAKE_NAME);
		List<Model> hyundaiModels;
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

		Mockito.lenient().when(modelRepository.findModelsOfMake(REQUESTED_MAKE_NAME)).thenReturn(hyundaiModels);
		Mockito.lenient().when(modelRepository.findModelByName(REQUESTED_MAKE_NAME, REQUESTED_MODEL_NAME)).thenReturn(
				new Model("Accent", Arrays.asList(
						new Version(2019, "Attractive", 46, new Engine("1.6 CRDi 128", FuelType.DIESEL)),
						new Version(2019, "BVA Attractive", 54, new Engine("1.6 CRDi 128", FuelType.DIESEL)),
						new Version(2019, "Inventive", 46,new Engine("1.6 CRDi 128", FuelType.DIESEL)),
						new Version(2019, "BVA Inventive", 54, new Engine("1.6 CRDi 128", FuelType.DIESEL))
				))
		);
	}

	@Test
	void getModelsOfMake() {
		// when
		List<Model> actualModels = modelService.getModelsOfMake(REQUESTED_MAKE_NAME);

		// then
		for (Model model : actualModels) {
			assertThat(model.getMake().getName()).isEqualTo(REQUESTED_MAKE_NAME);
		}
	}

	@Test
	void getModel() {
		// when
		Model actualModel = modelService.getModel(REQUESTED_MAKE_NAME, REQUESTED_MODEL_NAME);

		// then
		assertThat(actualModel.getName()).isEqualTo(REQUESTED_MODEL_NAME);
		assertThat(actualModel.getVersions().size()).isEqualTo((new String[] {"Attractive", "BVA Attractive", "Inventive", "BVA Inventive"}).length);
		assertThat(
				actualModel.getVersions()
				.stream()
				.map(Version::getTrim)
				.collect(Collectors.toList())
				.containsAll(Arrays.asList("Attractive", "BVA Attractive", "Inventive", "BVA Inventive"))
		).isTrue();
	}
}
