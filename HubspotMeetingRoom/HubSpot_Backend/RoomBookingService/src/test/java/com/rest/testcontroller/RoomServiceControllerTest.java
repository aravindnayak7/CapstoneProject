package com.rest.testcontroller;


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

import com.rest.mongo.controller.RoomController;
import com.rest.mongo.model.roomService;
import com.rest.mongo.service.IRoomService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomServiceControllerTest {

    @Mock
    private IRoomService roomService;

    @InjectMocks
    private RoomController roomController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveRoomDetailsHandler() {
        // Mock input
        roomService roomObj = new roomService();
        when(roomService.SaveRoomDetails(any(roomService.class))).thenReturn(roomObj);

        // Perform the test
        ResponseEntity<?> response = roomController.SaveRoomDetailsHandler(roomObj);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(roomObj, response.getBody());
    }

    @Test
    public void testUpdateRoomDetailsHandler() {
        // Mock input
        String roomId = "123";
        roomService roomObj = new roomService();
        when(roomService.updateRoomDetails(any(roomService.class), anyString())).thenReturn(roomObj);

        // Perform the test
        ResponseEntity<?> response = roomController.updateRoomDetailsHandler(roomObj, roomId);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(roomObj, response.getBody());
    }

    @Test
    public void testGetAllTRoomDetailsHandler() {
        // Mock input
        List<roomService> allRooms = new ArrayList<>();
        when(roomService.getAllRoomDetails()).thenReturn(allRooms);

        // Perform the test
        ResponseEntity<?> response = roomController.getAllTRoomDetailsHandler();

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(allRooms, response.getBody());
    }

    @Test
    public void testGetRoomDetailsByIdHandler() {
        // Mock input
        String roomId = "123";
        roomService roomObj = new roomService();
        when(roomService.getRoomById(anyString())).thenReturn(roomObj);

        // Perform the test
        ResponseEntity<?> response = roomController.getRoomDetailsByIdHandler(roomId);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(roomObj, response.getBody());
    }

    @Test
    public void testDeleteRoomByIdHandler() {
        // Mock input
        String roomId = "123";
        when(roomService.delRoom(anyString())).thenReturn(true);

        // Perform the test
        ResponseEntity<?> response = roomController.DeleteRoomByIdHandler(roomId);

        // Verify the result
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("roomService Details Deleted ....", response.getBody());
    }
}
