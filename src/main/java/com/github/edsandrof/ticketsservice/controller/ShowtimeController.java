package com.github.edsandrof.ticketsservice.controller;

import com.github.edsandrof.ticketsservice.domain.dto.ShowtimeDTO;
import com.github.edsandrof.ticketsservice.domain.model.Showtime;
import com.github.edsandrof.ticketsservice.facade.ShowtimeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/showtime")
@RestController
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeFacade facade;

    @GetMapping("/{movieId}")
    public ResponseEntity<?> getByMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(facade.findByMovieId(movieId));
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody ShowtimeDTO showtimeDTO) {
        Showtime showtime = facade.register(showtimeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
