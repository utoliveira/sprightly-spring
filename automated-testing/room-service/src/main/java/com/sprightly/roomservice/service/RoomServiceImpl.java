package com.sprightly.roomservice.service;

import com.sprightly.roomservice.exception.RoomServiceClientException;
import com.sprightly.roomservice.model.Room;
import com.sprightly.roomservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements  RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room findRoom(Long id) {
        return roomRepository.getOne(id);
    }

    @Override
    public void updateRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Room findByRoomNumber(String number) {

        if(number == null || !number.startsWith("Room ")){throw new RoomServiceClientException("Room number: "+number+", is an invalid room number format.");}

        Room room = roomRepository.findByNumber(number);

        if(room == null){
            throw new RoomServiceClientException("Room number "+ number + " doesn't exist");
        }

        return room;
    }

}
