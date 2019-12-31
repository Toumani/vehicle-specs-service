package com.tripplanner.api.controller

import com.tripplanner.api.entity.Make
import com.tripplanner.api.service.MakeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/make")
class MakeController (
		@Autowired
		private val makeService: MakeService
	) {

	@GetMapping("/populate")
	fun populate() {
		makeService.populate()
	}

	@GetMapping("/all")
	fun getAllMakes(): ResponseEntity<List<Make>> {
		return ResponseEntity.ok(makeService.getAllMakes())
	}
}