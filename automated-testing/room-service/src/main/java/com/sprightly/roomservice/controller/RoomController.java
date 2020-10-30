package com.sprightly.roomservice.controller;

import com.sprightly.roomservice.model.Room;
import com.sprightly.roomservice.service.RoomService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
@NoArgsConstructor
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping
    public ResponseEntity<Iterable<Room>> getAllRooms(){
        return ResponseEntity.ok(service.getAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findRoomById(@PathVariable Long id){
        return ResponseEntity.ok(service.findRoom(id));
    }

    @PostMapping
    public ResponseEntity<?> addRoom(Room room){
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }

}
