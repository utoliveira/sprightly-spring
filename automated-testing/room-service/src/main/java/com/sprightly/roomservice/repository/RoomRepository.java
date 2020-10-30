package com.sprightly.roomservice.repository;

import com.sprightly.roomservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByNumber(String number);
}
