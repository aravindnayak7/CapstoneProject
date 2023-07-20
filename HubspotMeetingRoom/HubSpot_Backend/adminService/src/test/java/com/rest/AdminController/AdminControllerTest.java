package com.rest.AdminController;
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

import com.admin.controller.AdminController;
import com.admin.feign.IAdminConsumer;
import com.admin.model.RoomData;
import com.admin.service.IAdminService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AdminControllerTest {

    @Mock
    private IAdminService adminService;

    @Mock
    private IAdminConsumer consumer;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveRoomDetailsHandler() {
        // Mock input
        RoomData roomData = new RoomData();
        when(adminService.SaveRoomDetails(any(RoomData.class))).thenReturn(roomData);

        // Perform the test
        ResponseEntity<?> response = adminController.SaveRoomDetailsHandler(roomData);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(roomData, response.getBody());
    }

    @Test
    public void testUpdateRoomDetailsHandler() {
        // Mock input
        String roomId = "123";
        RoomData roomData = new RoomData();
        when(adminService.updateRoomDetails(any(RoomData.class), anyString())).thenReturn(roomData);

        // Perform the test
        ResponseEntity<?> response = adminController.updateRoomDetailsHandler(roomData, roomId);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(roomData, response.getBody());
    }

    @Test
    public void testGetRoomDetailsByIdHandler() {
        // Mock input
        String roomId = "123";
        RoomData roomData = new RoomData();
        when(adminService.getRoomById(anyString())).thenReturn(roomData);

        // Perform the test
        ResponseEntity<?> response = adminController.getRoomDetailsByIdHandler(roomId);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(roomData, response.getBody());
    }

    @Test
    public void testDeleteRoomByIdHandler() {
        // Mock input
        String roomId = "123";
        when(consumer.DeleteRoomByIdHandler(anyString())).thenReturn(true);

        // Perform the test
        ResponseEntity<?> response = adminController.DeleteRoomByIdHandler(roomId);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("roomService Details Deleted ....", response.getBody());
    }

    @Test
    public void testGetAllTRoomDetailsHandler() {
        // Mock input
        List<RoomData> allRooms = new ArrayList<>();
        when(adminService.getAllRoomDetails()).thenReturn(allRooms);

        // Perform the test
        ResponseEntity<?> response = adminController.getAllTRoomDetailsHandler();

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(allRooms, response.getBody());
    }
}
