package com.admin.service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.feign.IAdminJPA;
import com.admin.model.BookingData;
//import com.admin.model.RoomData;




@Service
public class IAdminServiceImplAR implements IAdminServiceAR {

	@Autowired
   private IAdminJPA jpaconsumer; 
	
	@Override
	public BookingData saveCustomer(BookingData cobj1) {
		  BookingData addnewdata = this.jpaconsumer.saveCustomerHandler(cobj1);
  		return addnewdata;
	}

	
	
	@Override
	public BookingData updateCustomer(BookingData cobj1, int cid) {
		BookingData upcus = this.jpaconsumer.updateCustomerHandler(cobj1, cid);
	    if (upcus != null) {
	        upcus.setDesignation(cobj1.getDesignation());
	        upcus = this.saveCustomer(cobj1);
	    } else {
	        System.out.println("Record does not exist");
	    }
	    return upcus;
	}

	@Override
	public BookingData getCustomerById(int cid) {
		BookingData getcus = this.jpaconsumer.getCustomerByIdHandler(cid);
	    if (getcus != null) {
	        System.out.println("Record already exists");
	        return getcus;
	    } else {
	        System.out.println("Customer not found");
	        
	    }
		return getcus;
	}

	@Override
	public List<BookingData> getAllCustomers() {
        
		return this.jpaconsumer.getAllCustomersHandler();
	}

	@Override
	public boolean delCustomer(int cid) {
     
		boolean status = false;
		status = this.jpaconsumer.delCustomerHandler(cid);
	    
	    if (status) {
	        this.jpaconsumer.delCustomerHandler(cid);
	       
	    } else {
	        System.out.println("Record is not present");
	    }
	    return status;
	}

}
