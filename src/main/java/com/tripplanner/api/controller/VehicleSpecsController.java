package com.tripplanner.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// @RestController
public class VehicleSpecsController {

	private int something;
	private String anotherThing;

	public VehicleSpecsController(int something) {
		this.something = something;
	}

	public VehicleSpecsController(int something, String anotherThing) {
		this.something = something;
		this.anotherThing = anotherThing;
	}

	// @GetMapping("")
	public List<String> makeList() {
		System.out.println("I love Java");
		return new ArrayList<>();
	}
}