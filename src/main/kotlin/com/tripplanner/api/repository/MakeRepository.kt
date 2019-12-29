package com.tripplanner.api.repository

import com.tripplanner.api.entity.Make
import org.springframework.data.jpa.repository.JpaRepository

interface MakeRepository : JpaRepository<Make, Int> {
}