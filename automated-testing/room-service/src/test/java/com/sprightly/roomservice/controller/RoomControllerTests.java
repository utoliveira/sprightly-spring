package com.sprightly.roomservice.controller;

import com.jayway.jsonpath.JsonPath;
import com.sprightly.roomservice.model.Room;
import com.sprightly.roomservice.service.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RoomController.class)
public class RoomControllerTests {

    @MockBean
    private RoomService roomService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSuccessFindAllRooms() throws Exception{
        when(roomService.getAllRooms()).thenReturn(Arrays.asList(Room.builder().build(), Room.builder().build()));
        mockMvc.perform(get("/rooms"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testFindAllRoomsServiceCalledOnce() throws Exception{
        mockMvc.perform(get("/rooms")).andExpect(status().isOk());
        verify(roomService, times(1)).getAllRooms();
    }

    @Test
    public void testSuccessFindRoomById() throws Exception{
        Room room = Room.builder().floor("100").build();
        when(roomService.findRoom(BDDMockito.anyLong())).thenReturn(room);
        mockMvc.perform(get("/rooms/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("floor").value("100"));
    }




}
