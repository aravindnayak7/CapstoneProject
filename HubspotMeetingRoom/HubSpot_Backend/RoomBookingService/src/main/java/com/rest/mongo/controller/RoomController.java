package com.rest.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.mongo.model.roomService;
import com.rest.mongo.service.IRoomService;

@RestController
@RequestMapping("/room")
@CrossOrigin(origins ="http://localhost:4200", maxAge = 5000)
public class RoomController
{
    @Autowired
	private IRoomService roomService;
    
    //http://localhost:8080/room/SaveRoomDetails 
  //http://localhost:8080/room/updateRoomDetails 
  //http://localhost:8080/room/getAllRoomDetails 
  //http://localhost:8080/room/getRoomDetailsById
  //http://localhost:8080/room/delRoomById 
    
    private ResponseEntity<?> responseEntity;
    
    @PostMapping("/SaveRoomDetails")
    public ResponseEntity<?> SaveRoomDetailsHandler(@RequestBody roomService roomobj)
    {
    	roomService newroomobj = this.roomService.SaveRoomDetails(roomobj);
    	responseEntity=new ResponseEntity<roomService>(newroomobj, HttpStatus.CREATED);
    	return responseEntity;
    }
    
    
    
    
    
    
    
    @PutMapping("/updateRoomDetails/{roomId}")
	public ResponseEntity<?> updateRoomDetailsHandler(@RequestBody roomService roomobj, @PathVariable String roomId)
	{
		roomService newroomobj = this.roomService.updateRoomDetails(roomobj,roomId);
		responseEntity = new ResponseEntity<>(newroomobj,HttpStatus.CREATED);
		return responseEntity;
	}

    
    
    
    
    
	@GetMapping("/getAllRoomDetails")
	public ResponseEntity<?> getAllTRoomDetailsHandler()
	{
		List<roomService> allroom = this.roomService.getAllRoomDetails();
		responseEntity = new ResponseEntity<>(allroom,HttpStatus.OK);
		return responseEntity;
	}
	
	
	

	
	
	
	
	@GetMapping("/getRoomDetailsById/{roomId}")
	public ResponseEntity<?> getRoomDetailsByIdHandler(@PathVariable String roomId)
	{
		roomService roomobj = this.roomService.getRoomById(roomId);
		responseEntity = new ResponseEntity<>(roomobj,HttpStatus.OK);
		return responseEntity;
	}
	
	
	
	
	
	

	@DeleteMapping("/delRoomById/{roomId}")
	public ResponseEntity<?> DeleteRoomByIdHandler(@PathVariable String roomId)
	{
		boolean status = this.roomService.delRoom(roomId);
		responseEntity = new ResponseEntity<>("roomService Details Deleted ....",HttpStatus.OK);
		return responseEntity;
	}

	


}
    
    	
	
	
	
