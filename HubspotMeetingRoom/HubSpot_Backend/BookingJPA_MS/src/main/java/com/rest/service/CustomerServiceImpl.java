package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.CustomerAlreadyExistsException;
import com.rest.exception.CustomerNotFoundException;
import com.rest.model.Customer;
import com.rest.repository.ICustomerRepository;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository cusrepo;
	@Override
	public Customer saveCustomer(Customer cobj) throws CustomerAlreadyExistsException {
		Optional<Customer> optional=this.cusrepo.findById(cobj.getBookingId());
		Customer addcus=null;
		if(optional.isPresent()) {
			System.out.println("record already exist");
			throw new CustomerAlreadyExistsException();
		}else {
			addcus=this.cusrepo.save(cobj);
		}
		return addcus;
	}

	@Override
	public Customer updateCustomer(Customer cobj, int cid) throws CustomerNotFoundException {
		Optional<Customer> optional=this.cusrepo.findById(cid);
		Customer upcus=null;
		if(optional.isPresent()) {
			upcus=optional.get();
			upcus.setDesignation(cobj.getDesignation());
			upcus=this.cusrepo.save(cobj);
		}else {
			System.out.println("record not exists");
		}
		return upcus;
	}

	@Override
	public Customer getCustomerById(int cid) throws CustomerNotFoundException {
		Optional<Customer> optional=this.cusrepo.findById(cid);
		Customer getcus=null;
		if(optional.isPresent()) {
			System.out.println("record already exist");
			getcus=optional.get();
		}else {
			System.out.println("Customer Not Found");
			throw new CustomerNotFoundException();
		}
		return getcus;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return this.cusrepo.findAll();
	}

	@Override
	public boolean delCustomer(int cid) throws CustomerNotFoundException {
		Optional<Customer> optional=this.cusrepo.findById(cid);
		boolean status=false;
		if(optional.isPresent()) {
			this.cusrepo.delete(optional.get());
			status=true;
		}else {
			System.out.println("record is not present");
			throw new CustomerNotFoundException();
		}
		return false;
	}

}
