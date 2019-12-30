package com.tripplanner.api.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(uniqueConstraints = arrayOf(
		UniqueConstraint(columnNames = arrayOf(
				"name", "make_id"
		))
))
class Model() {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private var id: Int = 0

	@Column
	private var name: String = ""

	@ManyToOne
	private var make: Make = Make()

	constructor(name: String, make: Make) : this() {
		this.name = name
		this.make = make
	}

	fun getName(): String = name

	fun getMake(): Make = make
}