package com.tripplanner.api.dto

import com.tripplanner.api.entity.Version

class VersionDto {
	private lateinit var trim: String

	constructor() { }
	constructor(version: Version) {
		trim = version.getTrim()
	}

	fun getTrim() = trim
}