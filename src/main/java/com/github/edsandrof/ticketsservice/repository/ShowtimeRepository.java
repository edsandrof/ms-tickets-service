package com.github.edsandrof.ticketsservice.repository;

import com.github.edsandrof.ticketsservice.domain.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    List<Showtime> findAllByMovie_IdAndStartAtAfter(Long movieId, LocalDateTime now);
}
