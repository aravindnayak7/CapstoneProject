package com.rest.mongo.service;

import java.util.List;

import com.rest.mongo.model.roomService;

public interface IRoomService
{

	public roomService SaveRoomDetails(roomService roomobj);
	
	public  roomService updateRoomDetails ( roomService roomobj,String roomId );
	
	public  roomService getRoomById(String roomId);
	
	public List< roomService> getAllRoomDetails();
	
	public boolean delRoom(String roomId);
	

	

}


	

