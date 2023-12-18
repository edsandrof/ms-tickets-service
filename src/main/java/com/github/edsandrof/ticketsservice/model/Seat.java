package com.github.edsandrof.ticketsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private boolean reserved;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    @JsonIgnore
    @OneToMany(mappedBy = "seat")
    private List<Ticket> tickets;

}
