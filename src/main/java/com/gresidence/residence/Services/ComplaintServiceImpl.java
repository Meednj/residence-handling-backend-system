package com.gresidence.residence.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gresidence.residence.Dal.ComplaintRepository;
import com.gresidence.residence.Dal.ResidentRepository;
import com.gresidence.residence.Dto.ComplaintRequestDTO;
import com.gresidence.residence.Dto.ComplaintResponseDTO;
import com.gresidence.residence.Entities.Complaint;
import com.gresidence.residence.Entities.Resident;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final ResidentRepository residentRepository;

   private ComplaintResponseDTO mapToDTO(Complaint complaint) {
    return new ComplaintResponseDTO(
        complaint.getId(),
        complaint.getType(),
        complaint.getDescription(),
        complaint.getStatus(),
        complaint.getCreatedAt(),
        complaint.getResident().getId()
    );
}


    @Override
    public ComplaintResponseDTO createComplaint(Long residentId, ComplaintRequestDTO dto) {
        Resident resident = residentRepository.findById(residentId)
            .orElseThrow(() -> new RuntimeException("Resident not found"));

        Complaint complaint = new Complaint();
        complaint.setType(dto.getType());
        complaint.setDescription(dto.getDescription());
        complaint.setStatus("OPEN");
        complaint.setResident(resident);
        complaint.setCreatedAt(LocalDateTime.now());
        return mapToDTO(complaintRepository.save(complaint));
    }

    @Override
    public ComplaintResponseDTO getComplaintById(Long id) {
        return complaintRepository.findById(id)
            .map(this::mapToDTO)
            .orElseThrow(() -> new RuntimeException("Complaint not found"));
    }

    @Override
    public List<ComplaintResponseDTO> getAllComplaints() {
        return complaintRepository.findAll()
            .stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public List<ComplaintResponseDTO> getComplaintsByResident(Long residentId) {
        if (!residentRepository.existsById(residentId)) {
            throw new RuntimeException("Resident not found");
        }

        return complaintRepository.findByResidentId(residentId)
            .stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public List<ComplaintResponseDTO> getComplaintsByStatus(String status) {
        return complaintRepository.findByStatus(status)
            .stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public ComplaintResponseDTO changeStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaint.setStatus(status);
        return mapToDTO(complaintRepository.save(complaint));
    }

    @Override
    public void deleteComplaint(Long id) {
        if (!complaintRepository.existsById(id)) {
            throw new RuntimeException("Complaint not found");
        }
        complaintRepository.deleteById(id);
    }
}
