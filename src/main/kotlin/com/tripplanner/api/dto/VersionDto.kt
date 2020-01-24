package com.tripplanner.api.dto

import com.tripplanner.api.entity.Version

class VersionDto {
	private lateinit var trim: String
	private var fuelConsumption: Int = 0

	constructor() { }
	constructor(version: Version) {
		trim = version.getTrim()
		fuelConsumption = version.getFuelConsumption()
	}

	fun getTrim() = trim
	fun getFuelConsumption() = fuelConsumption
}