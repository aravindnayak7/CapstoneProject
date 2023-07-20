package com.admin.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.admin.model.BookingData;
import com.admin.model.RoomData;




@FeignClient(name="RoomBookingService", url="http://localhost:8083/api/v1")
public interface IAdminJPA 
{
    //http://localhost:8083/api/v1/addCustomer
	@PostMapping("/addCustomer") //working
	public BookingData saveCustomerHandler(@RequestBody BookingData cobj1);
	
	@PutMapping("/updatecus/{cid}") //working
	public BookingData updateCustomerHandler(@RequestBody BookingData cobj1,@PathVariable int cid);
	
	@GetMapping("/getcusbyid/{cid}") //working
	public BookingData getCustomerByIdHandler(@PathVariable int cid);
	
	@GetMapping("/getAllcus") // working
	public List<BookingData> getAllCustomersHandler();
	
	@DeleteMapping("/delete/{cid}")
	public boolean delCustomerHandler(@PathVariable int cid);
	
	
}
