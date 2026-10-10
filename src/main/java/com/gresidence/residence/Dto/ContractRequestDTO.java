package com.gresidence.residence.Dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractRequestDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private Double monthlyRent;
}
