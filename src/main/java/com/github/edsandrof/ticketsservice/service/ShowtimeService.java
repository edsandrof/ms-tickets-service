package com.github.edsandrof.ticketsservice.service;

import com.github.edsandrof.ticketsservice.model.Showtime;
import com.github.edsandrof.ticketsservice.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeService {

    private final ShowtimeRepository repository;

    public List<Showtime> findByMovieId(Long movieId) {
        return repository.findAllByMovie_IdAndStartAtAfter(movieId, LocalDateTime.now());
    }
}
