package com.gresidence.residence.Dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContractResponseDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean active;
    private Double monthlyRent;
    private Long residentId;
    private Long apartmentId;
}