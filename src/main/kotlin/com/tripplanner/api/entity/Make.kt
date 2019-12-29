package com.tripplanner.api.entity

import javax.persistence.Entity
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Column



@Entity
class Make() {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private var id: Int = 0

	@Column
	private var name: String = ""

	constructor(name: String) : this() {
		this.name = name
	}

	fun getName(): String = name
}