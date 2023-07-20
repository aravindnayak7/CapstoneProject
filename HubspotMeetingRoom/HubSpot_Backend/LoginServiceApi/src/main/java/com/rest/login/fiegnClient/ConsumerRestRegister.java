package com.rest.login.fiegnClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rest.login.model.User;




@FeignClient(name  = "register-service", url = "http://localhost:8082/")
public interface ConsumerRestRegister {

	@PostMapping("api/authUser")
	public boolean validateUserHandler(@RequestBody User user);

}
