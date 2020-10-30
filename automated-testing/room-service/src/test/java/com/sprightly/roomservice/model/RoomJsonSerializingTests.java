package com.sprightly.roomservice.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RoomJsonSerializingTests {

    private JacksonTester<Room> json;
    private String roomValidJson = "{\"id\":1,\"floor_number\":\"10\",\"number\":null,\"weekdayPrice\":0.0,\"weekendPrice\":0.0,\"roomType\":null}";
    private String roomExtraFieldJson = "{\"id\":1,\"floor_number\":\"10\",\"number\":null,\"weekdayPrice\":0.0,\"weekendPrice\":0.0,\"roomType\":null,\"roomX\":null}";
    private String roomWithoutRequired = "{\"id\":1,\"number\":null,\"weekdayPrice\":0.0,\"weekendPrice\":0.0,\"roomType\":null,\"roomX\":null}";

    @Before
    public void setup(){
        ObjectMapper mapper = new ObjectMapper();
        JacksonTester.initFields(this, mapper);
    }

    @Test
    public void testValidFullParseJson() throws IOException, ParseException{
        Room room = Room.builder().id(1L).floor("10").build();
        this.json.write(room).equals(roomValidJson);
    }

    @Test
    public void testRequiredField() throws Exception{
        try{
            Room room = Room.builder().id(1L).build();
            this.json.parse(roomWithoutRequired);
            fail("An Exception Should had been thrown");
        }catch (Exception e){
            assertEquals(MismatchedInputException.class, e.getClass());
        }

    }
    @Test
    public void testIgnoreExtraField() throws IOException{
        try{
            json.parse(roomExtraFieldJson);
        }catch (Exception e){
            fail("An Exception should not had been thrown.");
        }
    }
}
