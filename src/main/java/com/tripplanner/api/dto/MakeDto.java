package com.tripplanner.api.dto;

import java.util.List;

public class MakeDto {
	public MakeDto() { }

	public MakeDto(String name, List<ModelDto> models) {
		this.name = name;
		this.models = models;
	}

	private String name = "";
	private List<ModelDto> models;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ModelDto> getModels() {
		return models;
	}
}
