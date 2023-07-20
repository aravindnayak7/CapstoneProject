package com.admin.service;

import java.util.List;

import com.admin.model.RoomData;


public interface IAdminService 
{

	
	public RoomData SaveRoomDetails(RoomData roomobj1);

    public RoomData updateRoomDetails(RoomData roomobj1, String roomId);

    public RoomData getRoomById(String roomId);

    public List<RoomData> getAllRoomDetails();

    public boolean delRoom(String roomId);
	
	
}
