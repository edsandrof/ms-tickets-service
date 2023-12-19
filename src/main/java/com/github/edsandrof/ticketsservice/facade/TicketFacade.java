package com.github.edsandrof.ticketsservice.facade;

import com.github.edsandrof.ticketsservice.domain.dto.TicketDTO;
import com.github.edsandrof.ticketsservice.domain.model.Seat;
import com.github.edsandrof.ticketsservice.domain.model.Showtime;
import com.github.edsandrof.ticketsservice.domain.model.Ticket;
import com.github.edsandrof.ticketsservice.domain.service.ShowtimeService;
import com.github.edsandrof.ticketsservice.domain.service.TicketService;
import com.github.edsandrof.ticketsservice.exception.SeatNotAvailableException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TicketFacade {

    private final ShowtimeService showtimeService;
    private final TicketService ticketService;

    public Ticket buy(TicketDTO ticketDTO) {
        Showtime showtime = showtimeService.findById(ticketDTO.getShowtimeId());
        Seat seat = showtime.getSeats().stream()
                .filter(s -> s.getId().equals(ticketDTO.getSeatId()))
                .filter(s -> !s.isReserved())
                .findFirst().orElseThrow(() -> new SeatNotAvailableException("The seat is not available"));

        Ticket ticket = new Ticket();
        ticket.setSeat(seat);
        ticket.setShowtime(showtime);
        ticket.setPrice(new BigDecimal("20.00"));

        return ticketService.register(ticket);
    }

    public Ticket findById(Long id) {
        return ticketService.getById(id);
    }

    public List<Ticket> findByShowtimeId(Long showtimeId) {
        Showtime showtime = showtimeService.findById(showtimeId);
        return ticketService.listAllByShowtime(showtime);
    }
}
