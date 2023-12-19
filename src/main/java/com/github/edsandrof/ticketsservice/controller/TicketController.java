package com.github.edsandrof.ticketsservice.controller;

import com.github.edsandrof.ticketsservice.domain.dto.TicketDTO;
import com.github.edsandrof.ticketsservice.facade.TicketFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ticket")
@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketFacade facade;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(facade.findById(id));
    }

    @GetMapping("/showtime/{showtimeId}")
    public ResponseEntity<?> getByShowtimeId(@PathVariable Long showtimeId) {
        return ResponseEntity.ok(facade.findByShowtimeId(showtimeId));
    }

    @PostMapping
    public ResponseEntity<?> buy(@RequestBody TicketDTO ticketDTO) {
        return ResponseEntity.ok(facade.buy(ticketDTO));
    }

}
