package com.hubspot.gateway.fiegnClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hubspot.gateway.model.User;

@FeignClient(name = "register-service", url = "http://localhost:8080/")
public interface IRegisterAuthConsumer {
	
	@GetMapping("api/v1/authUser")
	public boolean validateUserHandler(@RequestBody User user);
}
