		package com.admin.controller;

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

import com.admin.feign.IAdminConsumer;
import com.admin.model.BookingData;
import com.admin.model.RoomData;
import com.admin.service.IAdminService;
import com.admin.service.IAdminServiceAR;





@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins ="http://localhost:4200", maxAge = 5000)
public class AdminController 
{

	@Autowired
	private IAdminService adminservice;
	
	@Autowired
	private IAdminConsumer consumer;
	
	  private ResponseEntity<?> responseEntity;
	    
	    @PostMapping("/SaveRoomDetails") //Working
	    public ResponseEntity<?>SaveRoomDetailsHandler(@RequestBody RoomData roomobj1) 
	    {
	    	RoomData newroomobj = this.adminservice.SaveRoomDetails(roomobj1);
	    	responseEntity=new ResponseEntity<RoomData>(newroomobj, HttpStatus.CREATED);
	    	return responseEntity;
	    }
	    
	    
	    
	    @PutMapping("/updateRoomDetails/{roomId}")
	    public ResponseEntity<?> updateRoomDetailsHandler(@RequestBody RoomData roomobj, @PathVariable String roomId)
		{
	    	RoomData newroomobj = this.adminservice.updateRoomDetails(roomobj, roomId);
			responseEntity = new ResponseEntity<>(newroomobj,HttpStatus.CREATED);
			return responseEntity;
		}
	
	    
	    
	    @GetMapping("/getRoomDetailsById/{roomId}") // Working
		public ResponseEntity<?> getRoomDetailsByIdHandler(@PathVariable String roomId) 
	    {
			RoomData roomobj = this.adminservice.getRoomById(roomId);
			responseEntity = new ResponseEntity<>(roomobj,HttpStatus.OK);
			return responseEntity;
		}
			

		@DeleteMapping("/delRoomById/{roomId}") //Working
		public ResponseEntity<?> DeleteRoomByIdHandler(@PathVariable String roomId) 
		{
			boolean status = this.consumer.DeleteRoomByIdHandler(roomId);
			responseEntity = new ResponseEntity<>("roomService Details Deleted ....",HttpStatus.OK);
			return responseEntity;
		}
		
		@GetMapping("/getAllRoomDetails")  //Working
		public ResponseEntity<?> getAllTRoomDetailsHandler()
		{
			List<RoomData> allroom = this.adminservice.getAllRoomDetails();
			responseEntity = new ResponseEntity<>(allroom,HttpStatus.OK);
			return responseEntity;
		}
		
		
		
}
