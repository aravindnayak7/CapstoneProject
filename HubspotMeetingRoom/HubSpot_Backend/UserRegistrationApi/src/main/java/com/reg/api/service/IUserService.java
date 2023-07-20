package com.reg.api.service;

import java.util.List;

import com.reg.api.model.RegisterUser;

public interface IUserService {

	public RegisterUser saveUser(RegisterUser user);
	public RegisterUser getUserById(String email);
	public List<RegisterUser> getAllUSer();
	public boolean deleteUser(String email);
	public RegisterUser updateUser(RegisterUser user,String email);
	public boolean validateUser(String email,String password);
}
