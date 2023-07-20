package com.hubspot.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubspot.gateway.fiegnClient.IRegisterAuthConsumer;


@Service
public class GatewayService implements IGatewayService{

	@Autowired IRegisterAuthConsumer repository;
	
	

//	@Override
//	public User getUsrByEmail(User user) {
//		boolean st = repository.validateUserHandler(user);
//		if(st) {
//		return user;
//		}else {
//			return null;
//		}
//	}

}
