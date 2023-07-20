package com.rest.controllertest;
import com.rest.controller.CustomerController;

import com.rest.exception.CustomerAlreadyExistsException;

import com.rest.exception.CustomerNotFoundException;

import com.rest.model.Customer;

import com.rest.service.ICustomerService;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

 

import java.util.Arrays;

import java.util.List;

 

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 

public class CustomerControllerTest {

 

    @Mock
    @Autowired
    private ICustomerService customerService;

 

    @InjectMocks

    private CustomerController customerController;

 

    @BeforeEach

    public void setup() {

        MockitoAnnotations.initMocks(this);

    }

 

    @Test

    public void testSaveCustomerHandler() throws CustomerAlreadyExistsException {

        // Create a Customer object

        Customer customer = new Customer();

        // Set customer properties

 

        when(customerService.saveCustomer(customer)).thenReturn(customer);

 

        // Call the saveCustomerHandler method

        ResponseEntity<?> response = customerController.saveCustomerHandler(customer);

 

        // Verify the response

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        assertEquals(customer, response.getBody());

 

        verify(customerService, times(1)).saveCustomer(customer);

    }

 

    @Test

    public void testUpdateCustomerHandler() throws CustomerNotFoundException {

        // Create a Customer object

        Customer customer = new Customer();

        // Set customer properties

        int customerId = 1;

 

        when(customerService.updateCustomer(customer, customerId)).thenReturn(customer);

 

        // Call the updateCustomerHandler method

        ResponseEntity<?> response = customerController.updateCustomerHandler(customer, customerId);

 

        // Verify the response

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(customer, response.getBody());

 

        verify(customerService, times(1)).updateCustomer(customer, customerId);

    }

 

    @Test

    public void testGetCustomerByIdHandler() throws CustomerNotFoundException {

        // Create a Customer object

        Customer customer = new Customer();

        // Set customer properties

        int customerId = 1;

 

        when(customerService.getCustomerById(customerId)).thenReturn(customer);

 

        // Call the getCustomerByIdHandler method

        ResponseEntity<?> response = customerController.getCustomerByIdHandler(customerId);

 

        // Verify the response

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(customer, response.getBody());

 

        verify(customerService, times(1)).getCustomerById(customerId);

    }

 

    @Test

    public void testGetAllCustomersHandler() {

        // Create a list of Customer objects

        List<Customer> customers = Arrays.asList(new Customer(), new Customer());

 

        when(customerService.getAllCustomers()).thenReturn(customers);

 

        // Call the getAllCustomersHandler method

        ResponseEntity<?> response = customerController.getAllCustomersHandler();

 

        // Verify the response

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(customers, response.getBody());

 

        verify(customerService, times(1)).getAllCustomers();

    }

 

    @Test

    public void testDelCustomerHandler() throws CustomerNotFoundException {

        int customerId = 1;

        boolean status = true;

 

        when(customerService.delCustomer(customerId)).thenReturn(status);

 

        // Call the delCustomerHandler method

        ResponseEntity<?> response = customerController.delCustomerHandler(customerId);

 

        // Verify the response

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(status, response.getBody());

 

        verify(customerService, times(1)).delCustomer(customerId);

    }

}

 