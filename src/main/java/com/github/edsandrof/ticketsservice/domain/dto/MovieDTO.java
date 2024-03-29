package com.github.edsandrof.ticketsservice.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MovieDTO implements Serializable {

    private Long id;
    private String originalTitle;
    private DirectorDTO director;

    public record DirectorDTO (String name) implements Serializable {
    }
}
