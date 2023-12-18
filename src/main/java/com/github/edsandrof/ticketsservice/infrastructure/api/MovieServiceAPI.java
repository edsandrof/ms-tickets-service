package com.github.edsandrof.ticketsservice.infrastructure.api;

import com.github.edsandrof.ticketsservice.domain.dto.MovieDTO;
import com.github.edsandrof.ticketsservice.exception.MovieNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service-api", url = "${api.movie-service}")
public interface MovieServiceAPI {

    @GetMapping("/{id}")
    MovieDTO findById(@PathVariable Long id) throws MovieNotFoundException;
}
