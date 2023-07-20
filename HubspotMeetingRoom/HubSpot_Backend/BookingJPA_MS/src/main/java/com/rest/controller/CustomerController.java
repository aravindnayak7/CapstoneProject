package com.rest.controller;

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

import com.rest.exception.CustomerAlreadyExistsException;
import com.rest.exception.CustomerNotFoundException;
import com.rest.model.Customer;
import com.rest.service.ICustomerService;

@RestController
@RequestMapping("/book/v1")
@CrossOrigin(origins ="http://localhost:4200", maxAge = 5000)
public class CustomerController {
 @Autowired
 private ICustomerService cusService;
 private ResponseEntity<?> responseEntity;
 @PostMapping("/addCustomer")//working
	public ResponseEntity<?> saveCustomerHandler(@RequestBody Customer cobj)
	{
		Customer addcus=null;
		try {
			addcus=this.cusService.saveCustomer(cobj);
		}catch(CustomerAlreadyExistsException e) {
			e.printStackTrace();
		}
		responseEntity=new ResponseEntity<>(addcus,HttpStatus.CREATED);
		return responseEntity;
	}
	@PutMapping("/updatecus/{cid}")//
	public ResponseEntity<?> updateCustomerHandler(@RequestBody Customer cobj,@PathVariable int cid)throws CustomerNotFoundException{
		Customer upcus=this.cusService.updateCustomer(cobj, cid);
		responseEntity=new ResponseEntity<>(upcus,HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/getcusbyid/{cid}")//working
	public ResponseEntity<?> getCustomerByIdHandler(@PathVariable int cid)throws CustomerNotFoundException{
		Customer upcus=this.cusService.getCustomerById(cid);
		responseEntity=new ResponseEntity<>(upcus,HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/getAllcus")//working
	public ResponseEntity<?> getAllCustomersHandler(){
		List<Customer> allcus=this.cusService.getAllCustomers();
		responseEntity=new ResponseEntity<>(allcus,HttpStatus.OK);
		return responseEntity;
	}
	@DeleteMapping("/delete/{cid}")//working
	public ResponseEntity<?> delCustomerHandler(@PathVariable int cid)throws CustomerNotFoundException{
		boolean status=this.cusService.delCustomer(cid);
		responseEntity=new ResponseEntity<>(status,HttpStatus.OK);
		return responseEntity;
	}
}
