package com.github.edsandrof.ticketsservice.repository;

import com.github.edsandrof.ticketsservice.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
