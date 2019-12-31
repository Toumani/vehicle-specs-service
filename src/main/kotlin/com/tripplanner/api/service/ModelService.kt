package com.tripplanner.api.service

import com.tripplanner.api.entity.Model

interface ModelService {

	fun getModelsOfMake(makeName: String): List<Model>

}