package com.sprightly.roomservice.service;

import com.sprightly.roomservice.model.Room;

public interface RoomService {

    Iterable<Room> getAllRooms();
    Room findRoom(Long id);
    void updateRoom(Room room);
    void addRoom(Room room);
    Room findByRoomNumber(String number);
}
