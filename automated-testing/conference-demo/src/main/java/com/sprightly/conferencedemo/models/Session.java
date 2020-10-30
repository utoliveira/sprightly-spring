package com.sprightly.conferencedemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //By using identity strategy, JPA will utilize the postgres created sequence for primary key values.
    @Column(name = "session_id", nullable = false)
    @Getter @Setter
    private Long id;

    @Column(name = "session_name", nullable = false)
    @Getter @Setter
    private String name;

    @Column(name = "session_description", nullable = false)
    @Getter @Setter
    private String description;

    @Column(name = "session_length", nullable = false)
    @Getter @Setter
    private Integer length;

    @Getter @Setter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    private List<Speaker> speakers;

}
