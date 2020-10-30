package com.sprightly.roomservice.service;

import com.sprightly.roomservice.model.Room;
import com.sprightly.roomservice.repository.RoomRepository;
import com.sprightly.roomservice.service.RoomService;
import com.sprightly.roomservice.service.RoomServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoomServiceImplTest {

    @Test
    public void lookupExistingRoom(){
        RoomRepository mockRepo = mock(RoomRepository.class);
        when(mockRepo.findByNumber(anyString())).thenReturn(Room.builder().build());
        RoomService service = new RoomServiceImpl();

        Room room = service.findByRoomNumber("Room 100");
        assertNotNull(room);
    }

    @Test
    public void throwExceptionForNonExistingRoom(){
        RoomRepository mockRepo = mock(RoomRepository.class);
        when(mockRepo.findByNumber(anyString())).thenReturn(null);
        RoomService service = new RoomServiceImpl();

        try{
            service.findByRoomNumber("Room 100");
            fail("Should throw an exception");
        }catch (Exception e){
            assertEquals("Room number Room 100 doesn't exist", e.getMessage());
        }
    }

    @Test
    public void throwExceptionInvalidRoomNumberFormat(){
        RoomRepository roomRepository = mock(RoomRepository.class);
        RoomService roomService = new RoomServiceImpl();

        try{
            roomService.findByRoomNumber("BAD ROOM NUMBER!");
            fail("Should have thrown an exception");
        }catch (Exception e){
            assertEquals("Room number: BAD ROOM NUMBER!, is an invalid room number format.", e.getMessage());
        }
    }

    @Test
    public void throwExceptionInvalidNumberNull(){
        RoomRepository roomRepository = mock(RoomRepository.class);
        RoomService roomService = new RoomServiceImpl();

        try{
            roomService.findByRoomNumber(null);
            fail("Should have thrown an exception");
        }catch (Exception e){
            assertEquals("Room number: null, is an invalid room number format.", e.getMessage());
        }
    }

}
