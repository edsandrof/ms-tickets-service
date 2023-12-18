package com.github.edsandrof.ticketsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.TimestampJdbcType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JdbcType(TimestampJdbcType.class)
    private LocalDateTime startAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @JsonIgnore
    @OneToMany(mappedBy = "showtime", orphanRemoval = true)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "showtime")
    private List<Seat> seats;
}
