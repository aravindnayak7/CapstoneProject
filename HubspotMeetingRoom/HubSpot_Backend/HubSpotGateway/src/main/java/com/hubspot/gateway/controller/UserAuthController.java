package com.hubspot.gateway.controller;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubspot.gateway.fiegnClient.IRegisterAuthConsumer;
import com.hubspot.gateway.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@RequestMapping
@CrossOrigin(origins ="http://localhost:4200", maxAge = 5000)
public class UserAuthController {
	
	private Map<String,String> map = new HashMap<>();


	@Autowired
	private IRegisterAuthConsumer userService;
	

	@GetMapping("/")
	public String serverStarted() {
		return "Authentication Server Started";
	}
	
	
	@PostMapping("/authUser")
	public ResponseEntity<?> doLogin(@RequestBody User user){
		try {
			String jwtToken = generateToken(user.getEmail(), user.getPassword(),user);
		
			map.put("message", "User Successfully LoggedIn");
			
			map.put("token", jwtToken);
		
		} catch (Exception e) {
			map.put("message", e.getMessage());
			map.put("token", null);
			return new ResponseEntity<>(map,HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}

	private String generateToken(String username, String password,User user) throws ServletException 
	{
		String jwtToken = "";
		if(username == null || password == null) {
			throw new ServletException("Please send valid username and password");
		}
	
		boolean flag = 	userService.validateUserHandler(user);
		if(!flag)
			throw new ServletException("Invalid Credentials");
		else {
			jwtToken = Jwts.builder()
					        .setSubject(username)
					        .setIssuedAt(new Date())
					        .setExpiration(new Date(System.currentTimeMillis() + 3000000))
					        .signWith(SignatureAlgorithm.HS256, "secret key")
					        .compact();
		}
		return jwtToken;
	}
}
