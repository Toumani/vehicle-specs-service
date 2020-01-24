package com.tripplanner.api.controller

import com.tripplanner.api.dto.MakeDto
import com.tripplanner.api.entity.Make
import com.tripplanner.api.service.MakeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
@CrossOrigin(origins = ["*"])
class MakeController (
		@Autowired
		private val makeService: MakeService
	) {

	@GetMapping("/populate")
	fun populate() {
		makeService.populate()
	}

	@GetMapping("/make/all")
	fun getAllMakes(): ResponseEntity<List<MakeDto>> {
		return ResponseEntity.ok(makeService.getAllMakes().map { MakeDto(it) })
	}

	@GetMapping("/cars/{makeName}", produces = ["application/json"])
	fun getMake(@PathVariable makeName: String): ResponseEntity<MakeDto> {
		return ResponseEntity.ok(MakeDto(makeService.getMake(makeName)))
	}
}