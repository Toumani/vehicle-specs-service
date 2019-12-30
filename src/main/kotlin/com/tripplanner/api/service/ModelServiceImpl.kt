package com.tripplanner.api.service

import com.tripplanner.api.entity.Model
import com.tripplanner.api.repository.MakeRepository
import com.tripplanner.api.repository.ModelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ModelServiceImpl(
		@Autowired val modelRepository: ModelRepository,
		@Autowired val makeRepository: MakeRepository
	) : ModelService {

	override fun populate() {
		val hyundai = makeRepository.findByName("Hyundai")
		val hyundaiModel: List<Model> = listOf(
				Model("Grand i10", hyundai),
				Model("i20", hyundai),
				Model("Accent", hyundai),
				Model("i30", hyundai),
				Model("Elantra", hyundai),
				Model("Creta", hyundai),
				Model("Kona", hyundai),
				Model("IONIQ", hyundai),
				Model("Tucson", hyundai),
				Model("i40", hyundai),
				Model("Santa Fe", hyundai)
		)
		modelRepository.saveAll(hyundaiModel)
	}

	override fun getModelsOfMake(makeName: String): List<Model> {
		return this.modelRepository.findModelsOfMake(makeName)
	}
}