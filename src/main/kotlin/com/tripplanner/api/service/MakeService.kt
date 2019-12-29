package com.tripplanner.api.service

import com.tripplanner.api.entity.Make
import org.springframework.stereotype.Service

@Service
interface MakeService {

    fun getAllMakes(): List<Make>

}