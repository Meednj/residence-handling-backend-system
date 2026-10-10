package com.gresidence.residence.Entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "CONTRACTS")
public class Contract {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean active;
    private Double monthlyRent;
    @OneToMany(mappedBy = "contract")
    private List<Payment> listPayments;
    @ManyToOne
    @JoinColumn(name = "residentId")
    private Resident resident;
    @ManyToOne
    @JoinColumn(name = "apartmentId")
    private Apartment apartment;

}
