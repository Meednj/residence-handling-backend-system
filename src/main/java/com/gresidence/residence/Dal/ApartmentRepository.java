package com.gresidence.residence.Dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gresidence.residence.Entities.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Long>{

    List<Apartment> findByStatus(String status);

    List<Apartment> findByNumber(int number);

    boolean existsByNumber(int number);
}
