package com.tripplanner.api.entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "make_id")
	private var make: Make = Make()

	@OneToMany(
			cascade = [(CascadeType.ALL)],
			orphanRemoval = true
	)
	private var versions: List<Version> = ArrayList()

	constructor(name: String, make: Make) : this() {
		this.name = name
		this.make = make
	}

	constructor(name: String, versions: List<Version>) : this() {
		this.name = name
		this.setVersions(versions)
	}

	constructor(name: String, make: Make, versions: List<Version>) : this() {
		this.name = name
		this.make = make
		this.setVersions(versions)
	}

	fun getName(): String = name

	fun getMake(): Make = make

	fun getVersions() = versions

	fun setMake(make: Make) { this.make = make}

	fun setVersions(versions: List<Version>) {
		for (version in versions) {
			version.setModel(this)
		}
		this.versions = versions
	}
}