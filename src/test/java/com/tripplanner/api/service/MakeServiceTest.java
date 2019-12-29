package com.tripplanner.api.service;

import com.tripplanner.api.entity.Make;
import com.tripplanner.api.repository.MakeRepository;
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
class MakeServiceTest {

	private MakeServiceImpl makeService;

	@BeforeEach
	void setup(@Mock MakeRepository makeRepository) {
		makeService = new MakeServiceImpl(makeRepository);

		// given
		List<Make> repositoryMakes = new ArrayList<>();
		repositoryMakes.add(new Make("Alpha Romeo"));
		repositoryMakes.add(new Make("Bentley"));
		repositoryMakes.add(new Make("Chevrolet"));
		repositoryMakes.add(new Make("Dacia"));

		Mockito.lenient().when(makeRepository.findAll()).thenReturn(repositoryMakes);
	}

	@Test
	void getAllMakes() {
		// when
		List<Make> serviceMakes = makeService.getAllMakes();

		// then
		assertThat(serviceMakes.size()).isEqualTo(4);
	}
}
