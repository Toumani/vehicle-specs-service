package com.tripplanner.api.dto

import com.tripplanner.api.entity.Make

class MakeDto {
	var name = ""
	lateinit var models: List<ModelDto>
		private set

	constructor() { }
	constructor(name: String, models: List<ModelDto>) {
		this.name = name
		this.models = models
	}

	constructor(make: Make) {
		this.name = make.getName()
		this.models = make.getModels().map { ModelDto(it) }
	}

}