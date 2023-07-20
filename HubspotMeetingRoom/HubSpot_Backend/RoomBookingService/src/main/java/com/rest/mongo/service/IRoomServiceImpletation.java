package com.rest.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.mongo.model.roomService;
import com.rest.mongo.repository.IRoomServiceRepositroy;

@Service
public class IRoomServiceImpletation implements IRoomService {
	
	@Autowired
	private IRoomServiceRepositroy roomrepository;

	@Override
	public roomService SaveRoomDetails(roomService roomobj) {
		roomService addroom=this.roomrepository.insert(roomobj);
      
		return addroom;
      
    		  
	}




@Override
public roomService updateRoomDetails(roomService roomobj, String roomId) {
//	get the user details which to be updated by passing the user id
	Optional<roomService> roomOptional = this.roomrepository.findById(roomId);

	roomService roomobj1 = null;
	roomService updatedData = null;

//	Checking whether user id exists or not
    if(roomOptional.isPresent())
    {
    	System.out.println("Record Exists and ready for Update !!!");

//    	Extracting the user details as user object from optional
    	roomobj1 = roomOptional.get();

//    	setting the updated value to setter method by taking from user through getter
       	roomobj1.setRoomName(roomobj.getRoomName());
    	roomobj1.setCapacity(roomobj.getCapacity());
    	roomobj1.setPrice(roomobj.getPrice());

//    	saving the final updated value to db
    	updatedData = this.roomrepository.save(roomobj1);

    }

//    returning the updated value to user
    return updatedData;
}







@Override
public roomService getRoomById(String roomId) {
	Optional<roomService> roomOptional = this.roomrepository.findById(roomId);

	roomService roomobj = null;

//	Checking whether user id exists or not
    if(roomOptional.isPresent())
    {
    	System.out.println("Record Exists and ready for Update !!!");

//    	Extracting the user details as user object from optional
    	roomobj = roomOptional.get();
    }
    else
    {
    	System.out.println("roomService does not exists");
    }

    return roomobj;
}











@Override
public List<roomService> getAllRoomDetails() {

	return this.roomrepository.findAll();
}






@Override
public boolean delRoom(String roomId) {
	Optional<roomService> roomOptional = this.roomrepository.findById(roomId);

	boolean status=false;

//	Checking whether user id exists or not
    if(roomOptional.isPresent())
    {
    	System.out.println("Record Exists and ready for Delete !!!");

//    	Extracting the user details as user object from optional
    	this.roomrepository.delete(roomOptional.get());
    	status=true;
    }
    else
    {
    	System.out.println("room details does not exits for delete ..");
    }
    return status;
}


}
