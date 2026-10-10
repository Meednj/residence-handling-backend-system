package com.gresidence.residence.Dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentResponseDTO {
    private Long id;
    private double amount;
    private LocalDate date;
    private String status;
    private Long contractId;
}
