package com.github.edsandrof.ticketsservice.domain.service;

import com.github.edsandrof.ticketsservice.domain.model.Showtime;
import com.github.edsandrof.ticketsservice.domain.model.Ticket;
import com.github.edsandrof.ticketsservice.exception.TicketNotFoundException;
import com.github.edsandrof.ticketsservice.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository repository;

    public List<Ticket> listAllByShowtime(Showtime showtime) {
        return showtime.getTickets();
    }

    public Ticket getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException("Ticket with id not found: " + id));
    }

    public Ticket register(Ticket ticket) {
        return repository.save(ticket);
    }
}
