package com.rest.controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.reg.api.controller.UserController;
import com.reg.api.exception.UserAlreadyExistException;
import com.reg.api.exception.UserNotFoundException;
import com.reg.api.model.RegisterUser;
import com.reg.api.service.IUserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserControllerTest {

    @Mock
    private IUserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUserHandler() throws UserAlreadyExistException {
        // Mock input
        RegisterUser userObj = new RegisterUser();
        when(userService.saveUser(any(RegisterUser.class))).thenReturn(userObj);

        // Perform the test
        ResponseEntity<?> response = userController.saveUserHandler(userObj);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userObj, response.getBody());
    }

    @Test
    public void testGetUsserHandler() throws UserNotFoundException {
        // Mock input
        String email = "test@example.com";
        RegisterUser userObj = new RegisterUser();
        when(userService.getUserById(anyString())).thenReturn(userObj);

        // Perform the test
        ResponseEntity<?> response = userController.getUsserHandler(email);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userObj, response.getBody());
    }

    @Test
    public void testGetAllUserHandler() {
        // Mock input
        List<RegisterUser> allUsers = new ArrayList<>();
        when(userService.getAllUSer()).thenReturn(allUsers);

        // Perform the test
        ResponseEntity<?> response = userController.getAllUserHandler();

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(allUsers, response.getBody());
    }

    @Test
    public void testDelUserHandler() throws UserNotFoundException {
        // Mock input
        String email = "test@example.com";
        when(userService.deleteUser(anyString())).thenReturn(true);

        // Perform the test
        ResponseEntity<?> response = userController.delUserHandler(email);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue((Boolean) response.getBody());
    }

    @Test
    public void testValidateUserHandler() throws UserNotFoundException {
        // Mock input
        RegisterUser userObj = new RegisterUser();
        userObj.setEmail("test@example.com");
        userObj.setPassword("password");
        when(userService.validateUser(anyString(), anyString())).thenReturn(true);

        // Perform the test
        ResponseEntity<?> response = userController.validateUserHandler(userObj);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue((Boolean) response.getBody());
    }

    @Test
    public void testUpateHandler() throws UserNotFoundException {
        // Mock input
        String email = "test@example.com";
        RegisterUser userObj = new RegisterUser();
        when(userService.updateUser(any(RegisterUser.class), anyString())).thenReturn(userObj);

        // Perform the test
        ResponseEntity<?> response = userController.upateHandler(userObj, email);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userObj, response.getBody());
    }
}
