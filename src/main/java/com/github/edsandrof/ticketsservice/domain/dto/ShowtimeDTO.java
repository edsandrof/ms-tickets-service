package com.github.edsandrof.ticketsservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowtimeDTO implements Serializable {

    @NotNull
    private final Long movieId;

    @NotNull
    @Future
    private final LocalDateTime startAt;
}