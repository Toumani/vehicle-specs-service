package com.tripplanner.api.entity

import com.tripplanner.api.constant.FuelType
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Engine() {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private var id: Int = 0

	@Column
	private var name: String = ""

	@Column
	private var fuelType: FuelType = FuelType.UNKNOWN

	@OneToMany(
			cascade = [(CascadeType.ALL)],
			orphanRemoval = true
	)
	private var versions: List<Version> = ArrayList()

	constructor(name: String, fuelType: FuelType) : this() {
		this.name = name
		this.fuelType = fuelType
	}

}