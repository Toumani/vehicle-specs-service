package com.tripplanner.api.service

import com.tripplanner.api.entity.Model
import com.tripplanner.api.repository.ModelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ModelServiceImpl(
		@Autowired val modelRepository: ModelRepository
	) : ModelService {

	override fun getModelsOfMake(makeName: String): List<Model> {
		return this.modelRepository.findModelsOfMake(makeName)
	}

	override fun getModel(makeName: String, modelName: String): Model {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}