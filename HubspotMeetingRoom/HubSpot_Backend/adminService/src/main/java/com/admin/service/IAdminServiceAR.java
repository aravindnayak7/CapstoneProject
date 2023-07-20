package com.admin.service;

import java.util.List;

import com.admin.model.BookingData;

public interface IAdminServiceAR 
{
	
	public BookingData saveCustomer(BookingData cobj1);
	public BookingData updateCustomer(BookingData cobj1,int cid);
	public BookingData getCustomerById(int cid);
	public List<BookingData> getAllCustomers();
	public boolean delCustomer(int cid);

}
