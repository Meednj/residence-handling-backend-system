package com.gresidence.residence.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "APARTMENTS")
public class Apartment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int floor;
    private int rooms;
    private double rent;
    private String status;
    @OneToMany(mappedBy = "apartment")
    private List<Contract> listContracts;
}
