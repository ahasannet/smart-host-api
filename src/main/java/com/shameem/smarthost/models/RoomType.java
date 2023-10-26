package com.shameem.smarthost.models;

public enum RoomType {

	ECONOMY("ECONOMY"),
	PREMIUM("PREMIUM");
	
	private String name;
	
	private RoomType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
