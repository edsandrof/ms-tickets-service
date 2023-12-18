package com.github.edsandrof.ticketsservice.controller;

import com.github.edsandrof.ticketsservice.model.Showtime;
import com.github.edsandrof.ticketsservice.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/showtime")
@RestController
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    @GetMapping("/{movieId}")
    public ResponseEntity<?> getByMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(showtimeService.findByMovieId(movieId));
    }

    public ResponseEntity<?> register(@RequestBody Showtime showtime) {
        return null;
    }

}
