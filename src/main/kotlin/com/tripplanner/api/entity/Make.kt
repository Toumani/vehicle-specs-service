package com.tripplanner.api.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany


@Entity
class Make() {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private var id: Int = 0

	@Column(unique = true)
	private var name: String = ""

	@OneToMany
	private var models: List<Model> = ArrayList<Model>()

	constructor(name: String) : this() {
		this.name = name
	}

	fun getName(): String = name

	fun getModels(): List<Model> = models
}