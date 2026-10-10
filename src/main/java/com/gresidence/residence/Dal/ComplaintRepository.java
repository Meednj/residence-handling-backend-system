package com.gresidence.residence.Dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gresidence.residence.Entities.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByResidentId(Long residentId);

    List<Complaint> findByStatus(String status);
}
