package com.gresidence.residence.Dal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gresidence.residence.Entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByContractId(Long contractId);

    List<Payment> findByStatus(String status);

    List<Payment> findByStatusAndDateBefore(String status, LocalDate date);
} 
