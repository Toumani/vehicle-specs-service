package com.tripplanner.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/make")
class MakesController {

    @GetMapping("/all")
    fun getAllMakes(): List<String> {
        val makes = ArrayList<String>()
        makes.add("Honda")
        makes.add("Ford")
        return makes
    }
}