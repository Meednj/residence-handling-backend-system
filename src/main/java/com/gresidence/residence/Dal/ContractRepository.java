package com.gresidence.residence.Dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gresidence.residence.Entities.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long>{

    List<Contract> findByResidentId(Long residentId);

    List<Contract> findByApartmentId(Long apartmentId);

    List<Contract> findByActiveTrue();
}