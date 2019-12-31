package com.tripplanner.api.service;

import com.tripplanner.api.entity.Make;
import com.tripplanner.api.entity.Model;
import com.tripplanner.api.repository.ModelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ModelServiceTest {

	private ModelServiceImpl modelService;

	private static final String REQUESTED_MAKE_NAME = "Hyundai";

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
}
