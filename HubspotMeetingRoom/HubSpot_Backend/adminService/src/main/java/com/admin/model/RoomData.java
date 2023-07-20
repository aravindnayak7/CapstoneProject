package com.admin.model;


public class RoomData 
{

	

	
	public String roomId;
    public String details;
	public String roomName;
	public int capacity;
	public String location;
	public int price;
	public String imgurl;
	public String duration;
	public String Starttime;
	public String EndTime;
	public String numberofRooms;
	public String email;
	public String checkin;
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStarttime() {
		return Starttime;
	}
	public void setStarttime(String starttime) {
		Starttime = starttime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getNumberofRooms() {
		return numberofRooms;
	}
	public void setNumberofRooms(String numberofRooms) {
		this.numberofRooms = numberofRooms;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public RoomData(String roomId, String details, String roomName, int capacity, String location, int price,
			String imgurl, String duration, String starttime, String endTime, String numberofRooms, String email,
			String checkin) {
		super();
		this.roomId = roomId;
		this.details = details;
		this.roomName = roomName;
		this.capacity = capacity;
		this.location = location;
		this.price = price;
		this.imgurl = imgurl;
		this.duration = duration;
		Starttime = starttime;
		EndTime = endTime;
		this.numberofRooms = numberofRooms;
		this.email = email;
		this.checkin = checkin;
	}
	public RoomData() {
		super();
	}
	@Override
	public String toString() {
		return "RoomData [roomId=" + roomId + ", details=" + details + ", roomName=" + roomName + ", capacity="
				+ capacity + ", location=" + location + ", price=" + price + ", imgurl=" + imgurl + ", duration="
				+ duration + ", Starttime=" + Starttime + ", EndTime=" + EndTime + ", numberofRooms=" + numberofRooms
				+ ", email=" + email + ", checkin=" + checkin + "]";
	}	
	
	
	
	
}