package com.shameem.smarthost.models;

public class HostSummary {
	
	private RoomType roomType;
	private Integer room;
	private Integer income;
	
	public HostSummary(RoomType roomType, Integer room, Integer income) {
		this.roomType = roomType;
		this.room = room;
		this.income = income;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}
	
}