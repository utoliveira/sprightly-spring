package com.sprightly.conferencedemo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@NoArgsConstructor
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //By using identity strategy, JPA will utilize the postgres created sequence for primary key values.
    @Column(name = "speaker_id")
    @Getter @Setter
    private Long id;

    @Column(name = "first_name", length = 30, nullable = false)
    @Getter @Setter
    private String firstName;

    @Column(name = "last_name", length = 30, nullable = false)
    @Getter @Setter
    private String lastName;

    @Column(length = 40, nullable = false)
    @Getter @Setter
    private String title;

    @Column(length = 50, nullable = false)
    @Getter @Setter
    private String company;

    @Column(name = "speaker_bio", length = 50, nullable = false)
    private String speakerBio;

    @Column(name = "speaker_photo")
    @Lob //Large object ->Helps JPA deal with the larger data
    @Type(type = "org.hibernate.type.BinaryType") //Helps hibernate to deal with binary data -> without it, would have a exception
    @Getter @Setter
    private byte[] speakerPhoto;

    @ManyToMany(mappedBy = "speakers", cascade = CascadeType.ALL)
    private List<Session> sessions;

}
