package com.github.edsandrof.ticketsservice.domain.service;

import com.github.edsandrof.ticketsservice.domain.dto.MovieDTO;
import com.github.edsandrof.ticketsservice.domain.model.Movie;
import com.github.edsandrof.ticketsservice.infrastructure.api.MovieServiceAPI;
import com.github.edsandrof.ticketsservice.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final MovieServiceAPI movieServiceAPI;

    public Movie findById(Long id) {
        return repository.findById(id).orElseGet(() -> {
                    MovieDTO movieDTO = movieServiceAPI.findById(id);
                    Movie movie = new Movie(id, movieDTO.getOriginalTitle(), movieDTO.getDirector().name());
                    return repository.save(movie);
                }
        );
    }
}
