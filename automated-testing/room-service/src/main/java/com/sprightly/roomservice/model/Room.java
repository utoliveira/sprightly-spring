package com.sprightly.roomservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
@Builder @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) /*Ignore the fields that are not recognizable when deserializing a JSON string*/
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "room_number")
    @Getter @Setter
    private String number;

    @Column(name="weekday_price")
    @Getter @Setter
    private double weekdayPrice;

    @Column(name="weekend_price")
    @Getter @Setter
    private double weekendPrice;

    @Column(name="room_type")
    @Getter @Setter
    private String roomType;

    @Column(name="floor")
    @Setter
    private String floor;

    @JsonProperty("floor_number") /*This is how it's gonna be serialized like this*/
    public String getFloor() {
        return floor;
    }

    @JsonCreator /*Jackson, please use this constructor when serialized a Json String*/
    public Room(@JsonProperty(value="id", defaultValue ="0L") long id,
                @JsonProperty(value = "floor_number", required = true) String floor){
        this.id = id;
        this.floor = floor;
    }
}
