package com.rest.login.controller;
//package com.rest.login.controller;

import com.rest.login.fiegnClient.ConsumerRestRegister;
import com.rest.login.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class LoginControllerTest{

    @Mock
    private ConsumerRestRegister userService;
    
   

    @InjectMocks
    private loginController loginController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testServerStarted() {
        // Act
        String response = loginController.serverStarted();

        // Assert
        assertEquals("Authentication Server Started", response);
    }

    @Test
    public void testDoLogin_Success() throws ServletException {
        // Arrange
        User user = new User("test@example.com", "password", null, null, null, null, 0, null);

        // Mocking the validateUserHandler method
        when(userService.validateUserHandler(any(User.class))).thenReturn(true);

        // Act
        ResponseEntity<?> response = loginController.doLogin(user);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Map<String, String> responseBody = (Map<String, String>) response.getBody();
        assertEquals("User Successfully LoggedIn", responseBody.get("message"));
        assertEquals("EXPECTED_JWT_TOKEN", responseBody.get("token")); // Replace with the expected JWT token
        verify(userService, times(1)).validateUserHandler(any(User.class));
    }

    @Test
    public void testDoLogin_InvalidCredentials() throws ServletException {
        // Arrange
        User user = new User("test@example.com","NCS","Fname","Lname","876554656545554", "password",23,"male");

        // Mocking the validateUserHandler method
        when(userService.validateUserHandler(any(User.class))).thenReturn(false);

        // Act
        ResponseEntity<?> response = loginController.doLogin(user);

        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        Map<String, String> responseBody = (Map<String, String>) response.getBody();
        assertEquals("Invalid Credentials", responseBody.get("message"));
        assertEquals(null, responseBody.get("token"));
        verify(userService, times(1)).validateUserHandler(any(User.class));
    }

    @Test
    public void testDoLogin_NullCredentials() throws ServletException {
        // Arrange
    	 User user = new User("","NCS","Fname","Lname","876554656545554", "",23,"male");

        // Act
        ResponseEntity<?> response = loginController.doLogin(user);

        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        Map<String, String> responseBody = (Map<String, String>) response.getBody();
        assertEquals("Please send valid username and password", responseBody.get("message"));
        assertEquals(null, responseBody.get("token"));
        verifyZeroInteractions(userService);
    }

    @Test(expected = ServletException.class)
    public void testGenerateToken_NullEmailAndPassword() throws ServletException {
        // Arrange
    	 User user = new User("","NCS","Fname","Lname","876554656545554", "",23,"male");

        // Act
    	 userService.validateUserHandler(user);
    }

    @Test(expected = ServletException.class)
    public void testGenerateToken_InvalidCredentials() throws ServletException {
        // Arrange
    	 User user = new User();

        // Mocking the validateUserHandler method
        when(userService.validateUserHandler(any(User.class))).thenReturn(false);

        // Act
        userService.validateUserHandler(user);
    }

    
}
