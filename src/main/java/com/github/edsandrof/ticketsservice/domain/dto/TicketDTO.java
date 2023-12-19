package com.github.edsandrof.ticketsservice.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketDTO {

    private Long showtimeId;
    private Long seatId;
}
