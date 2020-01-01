package com.tripplanner.api.service

import com.tripplanner.api.entity.Make
import com.tripplanner.api.repository.MakeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.tripplanner.api.populate as populateDatabase

@Service
class MakeServiceImpl(@Autowired val makeRepository : MakeRepository) : MakeService {

	override fun populate() {
        makeRepository.saveAll(populateDatabase())
	}

	override fun getAllMakes(): List<Make> {
		return this.makeRepository.findAll()
	}

	override fun getMake(makeName: String): Make {
		return makeRepository.findByName(makeName)
	}
}