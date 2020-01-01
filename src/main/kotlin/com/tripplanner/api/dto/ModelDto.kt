package com.tripplanner.api.dto

import com.tripplanner.api.entity.Model


class ModelDto {
	var name = ""
	lateinit var versions: List<VersionDto>
		private set

	constructor() { }
	constructor(model: Model) {
		name = model.getName()
		versions = model.getVersions().map { VersionDto(it) }
	}


}