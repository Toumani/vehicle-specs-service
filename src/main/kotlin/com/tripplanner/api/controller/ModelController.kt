package com.tripplanner.api.controller

import com.tripplanner.api.entity.Model
import com.tripplanner.api.service.ModelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/model")
class ModelController(
		@Autowired
		val modelService: ModelService
	) {

	@GetMapping("/{makeName}")
	fun getModelsOfMake(@PathVariable makeName: String): ResponseEntity<List<Model>> {
		return ResponseEntity.ok(modelService.getModelsOfMake(makeName))
	}

}