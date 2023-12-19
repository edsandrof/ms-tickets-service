package com.github.edsandrof.ticketsservice.domain.service;

import com.github.edsandrof.ticketsservice.domain.dto.ShowtimeDTO;
import com.github.edsandrof.ticketsservice.domain.model.Movie;
import com.github.edsandrof.ticketsservice.domain.model.Seat;
import com.github.edsandrof.ticketsservice.domain.model.Showtime;
import com.github.edsandrof.ticketsservice.exception.ShowtimeNotFoundException;
import com.github.edsandrof.ticketsservice.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeService {

    private static final int DEFAULT_CAPACITY = 5;

    private final ShowtimeRepository repository;

    public List<Showtime> findByMovieId(Long movieId) {
        return repository.findAllByMovie_IdAndStartAtAfter(movieId, LocalDateTime.now());
    }

    public Showtime register(ShowtimeDTO showtimeDTO, Movie movie) {
        Showtime showtime = new Showtime();
        showtime.setMovie(movie);
        showtime.setStartAt(showtimeDTO.getStartAt());
        showtime.setSeats(initializeSeats(DEFAULT_CAPACITY, showtime));

        return repository.save(showtime);
    }

    private List<Seat> initializeSeats(int capacity, Showtime showtime) {
        List<Seat> seats = new ArrayList<>(capacity);

        for (int i = 1; i <= capacity; i++) {
            seats.add(new Seat(i, showtime));
        }
        return seats;
    }

    public Showtime findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ShowtimeNotFoundException("Showtime with id not found: " + id));
    }
}
