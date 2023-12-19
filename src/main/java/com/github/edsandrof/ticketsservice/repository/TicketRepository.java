package com.github.edsandrof.ticketsservice.repository;

import com.github.edsandrof.ticketsservice.domain.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
