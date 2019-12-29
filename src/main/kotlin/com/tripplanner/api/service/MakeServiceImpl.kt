package com.tripplanner.api.service

import com.tripplanner.api.entity.Make
import com.tripplanner.api.repository.MakeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MakeServiceImpl(@Autowired val makeRepository : MakeRepository) : MakeService {

    override fun getAllMakes(): List<Make> {
        return this.makeRepository.findAll()
    }
}