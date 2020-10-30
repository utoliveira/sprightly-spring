package com.sprightly.roomservice.controller;

import com.sprightly.roomservice.configuration.SecurityConfig;
import com.sprightly.roomservice.service.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RoomController.class)
@Import(SecurityConfig.class)
public class RoomControllerSecurityTests {

    @MockBean
    private RoomService roomService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindAllRoomsWithNoUser() throws Exception{
        mockMvc.perform(get("/rooms")).andExpect(status().isUnauthorized());
    }
/*

    @Test
    public void testFindAllRoomsWithInvalidUser() throws  Exception{
        when(roomService.getAllRooms()).thenReturn(Arrays.asList(Room.builder().build()));
        mockMvc.perform(get("/rooms").with(user()))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testFindAllCustomersWithNoUser() throws Exception{
        mockMvc.perform(get("/rooms")).andExpect(status().isUnauthorized());
    }*/

}
