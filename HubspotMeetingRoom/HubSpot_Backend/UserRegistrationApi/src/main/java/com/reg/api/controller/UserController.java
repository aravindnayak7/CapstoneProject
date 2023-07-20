package com.reg.api.controller;

import java.util.List;

import org.apache.catalina.User;
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

import com.reg.api.exception.UserAlreadyExistException;
import com.reg.api.exception.UserNotFoundException;
import com.reg.api.model.RegisterUser;
import com.reg.api.service.IUserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:4200", maxAge = 5000)
public class UserController {
		
	
	//http://localhost:8085/api/user   
	//http://localhost:8085/api/v3/getAllUser  
	//http://localhost:8085/api/v3/getUser/{email}
	//http://localhost:8085/api/authUser
	//http://localhost:8085/api/v3/deleteUser/{email}
	
	@Autowired
	private IUserService userService;
	
	private ResponseEntity<?> resoponse;
	
	@PostMapping("/user")
	public ResponseEntity<?> saveUserHandler(@RequestBody RegisterUser uObj) throws UserAlreadyExistException{
		RegisterUser newUser=null;
		try {
			newUser = userService.saveUser(uObj);
			resoponse = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		} catch (Exception e) {
			resoponse = new ResponseEntity<>(newUser, HttpStatus.CONFLICT);
			throw new UserAlreadyExistException();
		}
		
		
		return resoponse;
	}
	
	@GetMapping("/v3/getUser/{email}")
	public ResponseEntity<?> getUsserHandler(@PathVariable String email)throws UserNotFoundException{
		RegisterUser r =null;
		try {
		r = userService.getUserById(email);
		resoponse = new ResponseEntity<>(r,HttpStatus.OK);
		}catch(Exception e) {
		resoponse = new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
		throw new UserNotFoundException();
		}
		return resoponse;
	}
	
	@GetMapping("/v3/getAllUser")
	public ResponseEntity<?> getAllUserHandler(){
		List<RegisterUser> r =null;
		try {
		r = userService.getAllUSer();
		resoponse = new ResponseEntity<>(r,HttpStatus.OK);
		}catch(Exception e) {
			resoponse = new ResponseEntity<>(r,HttpStatus.NOT_FOUND);

		}
		return resoponse;
	}
	
	@DeleteMapping("/v3/deleteUser/{email}")
	public ResponseEntity<?> delUserHandler(@PathVariable String email)throws UserNotFoundException{
		boolean r =false;
		try {
			
		r = userService.deleteUser(email);
		resoponse = new ResponseEntity<>(r,HttpStatus.OK);
			
		}catch(Exception e) {
			resoponse = new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
			throw new UserNotFoundException();
		}
		return resoponse;
	}
	
	@PostMapping("/authUser")
	public ResponseEntity<?> validateUserHandler(@RequestBody RegisterUser user)throws UserNotFoundException{
		boolean r =false;
		try {
		r = userService.validateUser(user.getEmail(), user.getPassword());
		if(r)
		resoponse = new ResponseEntity<>(r,HttpStatus.OK);
		else
			resoponse = new ResponseEntity<>(r,HttpStatus.UNAUTHORIZED);
		}catch(Exception e) {
			resoponse = new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
			throw new UserNotFoundException();
		}
		return resoponse;
	}
	
	@PutMapping("/v3/updateUser/{email}")
	public ResponseEntity<?> upateHandler(@RequestBody RegisterUser user,@PathVariable String email) throws UserNotFoundException{
		RegisterUser r =null;
		try {
		r = userService.updateUser(user,email);
		resoponse = new ResponseEntity<>(r,HttpStatus.OK);
		}catch(Exception e) {
		resoponse = new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
		throw new UserNotFoundException();

		}
		return resoponse;
	}
}
