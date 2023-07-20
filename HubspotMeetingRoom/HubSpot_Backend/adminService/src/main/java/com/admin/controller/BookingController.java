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

import com.admin.feign.IAdminJPA;
import com.admin.model.BookingData;
import com.admin.service.IAdminServiceAR;





@RestController
@RequestMapping("api/admin1")
@CrossOrigin(origins ="http://localhost:4200", maxAge = 5000)
public class BookingController
{
	
	@Autowired
	private IAdminServiceAR adminservicear;
	
	@Autowired
	private IAdminJPA  jpaconsumer;
	
	
	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> saveCustomerHandler(@RequestBody BookingData cobj1)
	{
		BookingData addcus1=null;
		addcus1=this.jpaconsumer.saveCustomerHandler(cobj1);
		responseEntity=new ResponseEntity<>(addcus1,HttpStatus.CREATED);
		return responseEntity;
	}
	
	
	@PutMapping("/updatecus/{cid}")
	public ResponseEntity<?> updateCustomerHandler(@RequestBody BookingData cobj1,@PathVariable int cid)
	{
		BookingData upcus=this.jpaconsumer.updateCustomerHandler(cobj1, cid);
		responseEntity=new ResponseEntity<>(upcus,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@GetMapping("/getcusbyid/{cid}")
	public ResponseEntity<?> getCustomerByIdHandler(@PathVariable int cid)
	{
		BookingData upcus=this.jpaconsumer.getCustomerByIdHandler(cid);
		responseEntity=new ResponseEntity<>(upcus,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@GetMapping("/getAllcus")
	public ResponseEntity<?> getAllCustomersHandler(){
		List<BookingData> allcus=this.adminservicear.getAllCustomers();      //ithe jpaconsumer service pahije mi admin use keli ahe check karnyasathi
		responseEntity=new ResponseEntity<>(allcus,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@DeleteMapping("/delete/{cid}")//working
	public ResponseEntity<?> delCustomerHandler(@PathVariable int cid){
		boolean status=this.jpaconsumer.delCustomerHandler(cid);
		responseEntity=new ResponseEntity<>(status,HttpStatus.OK);
		return responseEntity;
	}
	
	
	
	

	
	
}
