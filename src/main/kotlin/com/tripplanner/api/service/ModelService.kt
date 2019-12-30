package com.tripplanner.api.service

import com.tripplanner.api.entity.Model

interface ModelService {

	fun populate()

	fun getModelsOfMake(makeName: String): List<Model>

}