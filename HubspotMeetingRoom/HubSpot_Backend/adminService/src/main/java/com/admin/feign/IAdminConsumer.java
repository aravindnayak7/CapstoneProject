package com.admin.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.admin.model.RoomData;

@FeignClient(name="room-service", url="http://localhost:8084/room")
public interface IAdminConsumer 
{

	
	@PostMapping("/SaveRoomDetails")
	public RoomData SaveRoomDetailsHandler(@RequestBody RoomData roomobj1);
	
	@PutMapping("/updateRoomDetails/{roomId}")
	public RoomData updateRoomDetailsHandler(@RequestBody RoomData roomobj1, @PathVariable String roomId);
	
	@GetMapping("/getAllRoomDetails")
	public List<RoomData> getAllTRoomDetailsHandler();
	
	@GetMapping("/getRoomDetailsById/{roomId}")
	public RoomData getRoomDetailsByIdHandler(@PathVariable String roomId);
	
	@DeleteMapping("/delRoomById/{roomId}")
	public boolean DeleteRoomByIdHandler(@PathVariable String roomId);

}
