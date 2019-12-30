package com.tripplanner.api.repository

import com.tripplanner.api.entity.Model
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ModelRepository : JpaRepository<Model, Int> {

	@Query("SELECT m FROM Model m WHERE m.make.name = :makeName")
	fun findModelsOfMake(@Param("makeName") makeName: String): List<Model>

}