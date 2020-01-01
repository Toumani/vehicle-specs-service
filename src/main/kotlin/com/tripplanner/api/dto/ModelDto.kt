package com.tripplanner.api.dto

import com.tripplanner.api.entity.Model


class ModelDto {
	var name = ""

	constructor() { }
	constructor(model: Model) {
		name = model.getName()
	}
}