package com.sprightly.roomservice.repository;

import com.sprightly.roomservice.model.Room;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoomRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoomRepository roomRepository;

    private Room roomTest;

    public RoomRepositoryTests(){
        roomTest = Room.builder().roomType("type").floor("floor").build();
    }

    @After
    public void cleanup(){
        this.entityManager.clear();
    }

    @Test
    public void findAllCustomers(){
        this.entityManager.persist(roomTest);
        Collection<Room> rooms = roomRepository.findAll();
        for(Room room : rooms){
            assertEquals("type", room.getRoomType());
            assertEquals("floor", room.getRoomType());
            assertTrue(room.getId() > 0);
        }
        assertEquals(rooms.size(), 1);
    }


}
