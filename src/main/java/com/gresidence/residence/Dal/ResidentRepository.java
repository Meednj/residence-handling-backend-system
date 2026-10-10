package com.gresidence.residence.Dal;


import com.gresidence.residence.Entities.Resident;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
    Resident findByCin(String cin);

    List<Resident> findByNomContainingIgnoreCase(String nom);

    boolean existsByCin(String cin);
}
