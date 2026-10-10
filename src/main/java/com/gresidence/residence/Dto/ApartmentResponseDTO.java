package com.gresidence.residence.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApartmentResponseDTO {
    private Long id;
    private int number;
    private int floor;
    private int rooms;
    private double rent;
    private String status;
}
