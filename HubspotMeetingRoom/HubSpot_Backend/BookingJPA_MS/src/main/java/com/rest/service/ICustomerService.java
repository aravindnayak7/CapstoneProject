package com.rest.service;

import java.util.List;

import com.rest.exception.CustomerAlreadyExistsException;
import com.rest.exception.CustomerNotFoundException;
import com.rest.model.Customer;

public interface ICustomerService {
	public Customer saveCustomer(Customer cobj)throws CustomerAlreadyExistsException;
	public Customer updateCustomer(Customer cobj,int cid)throws CustomerNotFoundException;
	public Customer getCustomerById(int cid)throws CustomerNotFoundException;
	public List<Customer> getAllCustomers();
	public boolean delCustomer(int cid)throws CustomerNotFoundException;
}
