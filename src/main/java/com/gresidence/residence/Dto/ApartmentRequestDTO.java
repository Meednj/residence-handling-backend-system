package com.gresidence.residence.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartmentRequestDTO {
    private int number;
    private int floor;
    private int rooms;
    private double rent;
    private String status;
}
