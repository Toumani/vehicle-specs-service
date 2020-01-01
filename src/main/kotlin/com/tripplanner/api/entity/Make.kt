package com.tripplanner.api.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.CascadeType
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
	private var id: Int = 1

	@Column(unique = true)
	private var name: String = ""

	@JsonIgnore
	@OneToMany(
			cascade = [CascadeType.ALL],
			orphanRemoval = true
	)
	private var models: List<Model> = ArrayList()

	constructor(name: String) : this() {
		this.name = name
	}

	constructor(name: String, models: List<Model>) : this() {
		this.name = name

		for (model in models) {
			model.setMake(this)
		}
		this.models = models
	}

	fun getName(): String = name

	fun getModels(): List<Model> = models
}