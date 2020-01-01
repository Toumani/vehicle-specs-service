package com.tripplanner.api.controller

import com.tripplanner.api.dto.ModelDto
import com.tripplanner.api.service.ModelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ModelController(
		@Autowired
		val modelService: ModelService
	) {

	@GetMapping("/model/{makeName}")
	fun getModelsOfMake(@PathVariable makeName: String): ResponseEntity<List<ModelDto>> {
		return ResponseEntity.ok(
				modelService.getModelsOfMake(makeName).map { ModelDto(it) }
		)
	}

	@GetMapping("/cars/{makeName}/{modelName}")
	fun getModel(@PathVariable makeName: String, @PathVariable modelName: String): ResponseEntity<ModelDto> {
		return ResponseEntity.ok(ModelDto(modelService.getModel(makeName, modelName)))
	}

}