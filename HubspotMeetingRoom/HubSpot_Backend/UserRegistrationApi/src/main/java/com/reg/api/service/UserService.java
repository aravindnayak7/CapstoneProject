package com.reg.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reg.api.model.RegisterUser;
import com.reg.api.repository.IJpaRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IJpaRepository repository;
	
	
	@Override
	public RegisterUser saveUser(RegisterUser user)  {
		Optional<RegisterUser> isUser= repository.findById(user.getEmail());
		RegisterUser rObj1 =null;
		if(isUser.isPresent()) {
			
		}else {
		rObj1 = repository.saveAndFlush(user);
		}
		return rObj1;
	}
	
	@Override
	public RegisterUser getUserById(String email) {
		Optional<RegisterUser> r = repository.findById(email);
		RegisterUser res = null;
		if(r.isPresent()) {
			return res = r.get();
		}
		return res;
	}

	@Override
	public List<RegisterUser> getAllUSer() {
		
		return repository.findAll();
	}

	@Override
	public boolean deleteUser(String email) {
		Optional<RegisterUser> r = repository.findById(email);
		RegisterUser res = null;
		boolean st =false;
		if(r.isPresent()) {
			res = r.get();
			repository.delete(res);
			st = true;
		}
		return st;
	}

	@Override
	public boolean validateUser(String email, String password) {
		System.out.println(email+password);
		RegisterUser user = repository.validateUser(email,password);
		System.out.println(user);
		if(user!=null) {
		return true;
		}
		else {
			return false;
		}
	}

	@Override
	public RegisterUser updateUser(RegisterUser user,String email) {
		Optional<RegisterUser> r = repository.findById(email);
		RegisterUser res = null;
		RegisterUser r1 = null;
		if(r.isPresent()) {
			res = r.get();
			
//			res.setEmail(user.getEmail());
			res.setFirstName(user.getFirstName());
			res.setLastName(user.getLastName());
			res.setCompanyName(user.getCompanyName());
			res.setAge(user.getAge());
			res.setGender(user.getGender());
			res.setMobileNumber(user.getMobileNumber());
			res.setPassword(user.getPassword());
			
			r1 = repository.save(res);
		}
		return r1;
		
	}

}
