package com.github.edsandrof.ticketsservice.domain.model;

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
public class Movie {

    @Id
    private Long id;
    private String title;
    private String director;

    @JsonIgnore
    @OneToMany(mappedBy = "movie", orphanRemoval = true)
    private List<Showtime> showtimes;

    public Movie(Long id, String title, String director) {
        this.id = id;
        this.title = title;
        this.director = director;
    }
}
