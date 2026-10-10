package com.gresidence.residence.Services;

import java.util.List;

import com.gresidence.residence.Dto.ComplaintRequestDTO;
import com.gresidence.residence.Dto.ComplaintResponseDTO;

public interface ComplaintService {
    ComplaintResponseDTO createComplaint(Long residentId, ComplaintRequestDTO dto);
    ComplaintResponseDTO getComplaintById(Long id);
    List<ComplaintResponseDTO> getAllComplaints();
    List<ComplaintResponseDTO> getComplaintsByResident(Long residentId);
    List<ComplaintResponseDTO> getComplaintsByStatus(String status);
    ComplaintResponseDTO changeStatus(Long id, String status);
    void deleteComplaint(Long id);
}
