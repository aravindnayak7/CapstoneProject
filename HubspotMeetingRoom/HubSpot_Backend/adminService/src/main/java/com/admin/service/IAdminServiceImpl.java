package com.admin.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.feign.IAdminConsumer;
import com.admin.model.RoomData;


@Service
public class IAdminServiceImpl implements IAdminService 
{

	
	@Autowired
	private IAdminConsumer adminConsumer;
	
	
	@Override
	public RoomData SaveRoomDetails(RoomData roomobj1) {
	     RoomData addnewroom = this.adminConsumer.SaveRoomDetailsHandler(roomobj1);
	    		return addnewroom;
	}

	@Override
	public RoomData updateRoomDetails(RoomData roomobj1, String roomId) {
		RoomData updatedData = adminConsumer.updateRoomDetailsHandler(roomobj1, roomId);
	    if (updatedData != null) {
	        System.out.println("Record Exists and ready for Update !!!");
	        // Updating the room details
	        updatedData.setDetails(roomobj1.getDetails());
	        updatedData.setCheckin(roomobj1.getCheckin());
	        updatedData.setDuration(roomobj1.getDuration());
	        updatedData.setEndTime(roomobj1.getEndTime());
	        updatedData.setLocation(roomobj1.getLocation());
	        updatedData.setRoomName(roomobj1.getRoomName());
	        updatedData.setCapacity(roomobj1.getCapacity());
	        updatedData.setPrice(roomobj1.getPrice());
	        // Saving the final updated value to the database is already handled by the Feign client
	    }
	    return updatedData;
	}

	@Override
	public RoomData getRoomById(String roomId) {
		 return adminConsumer.getRoomDetailsByIdHandler(roomId);

	}

	@Override
	public List<RoomData> getAllRoomDetails() 
	{
		return this.adminConsumer.getAllTRoomDetailsHandler();
	}
	
	

	@Override
	public boolean delRoom(String roomId) {
		boolean status = this.adminConsumer.DeleteRoomByIdHandler(roomId);
		return status;
	}

}
