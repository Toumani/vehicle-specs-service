package com.tripplanner.api.entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Version() {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private var id: Int = 0

	@Column
	private var year: Int = 1950

	@Column
	private var trim: String = ""

	@Column
	private var fuelConsumption: Int = 0

	@ManyToOne(cascade = [(CascadeType.ALL)])
	var engine: Engine = Engine()

	@ManyToOne(cascade = [(CascadeType.ALL)])
	private var model: Model = Model()

	constructor(year: Int, trim: String, fuelConsumption: Int, engine: Engine) : this() {
		this.year = year
		this.trim = trim
		this.fuelConsumption = fuelConsumption
		this.engine = engine
	}

	fun getYear(): Int = this.year

	fun getTrim(): String = this.trim

	fun getFuelConsumption(): Int = this.fuelConsumption

	fun setModel(model: Model) {
		this.model = model
	}
}