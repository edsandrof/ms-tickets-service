package com.github.edsandrof.ticketsservice.facade;

import com.github.edsandrof.ticketsservice.domain.dto.ShowtimeDTO;
import com.github.edsandrof.ticketsservice.domain.model.Movie;
import com.github.edsandrof.ticketsservice.domain.model.Showtime;
import com.github.edsandrof.ticketsservice.domain.service.MovieService;
import com.github.edsandrof.ticketsservice.domain.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShowtimeFacade {

    private final ShowtimeService showtimeService;
    private final MovieService movieService;

    public List<Showtime> findByMovieId(Long movieId) {
        return showtimeService.findByMovieId(movieId);
    }

    public Showtime register(ShowtimeDTO showtimeDTO) {
        Movie movie = movieService.findById(showtimeDTO.getMovieId());
        return showtimeService.register(showtimeDTO, movie);
    }
}
