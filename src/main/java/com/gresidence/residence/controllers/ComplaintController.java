package com.gresidence.residence.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.gresidence.residence.Dto.ComplaintRequestDTO;
import com.gresidence.residence.Dto.ComplaintResponseDTO;
import com.gresidence.residence.Entities.Complaint;
import com.gresidence.residence.Services.ComplaintService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/gresidence/residence/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping
    public ComplaintResponseDTO createComplaint(
            @RequestParam Long residentId,
            @RequestBody ComplaintRequestDTO complaint) {
        return complaintService.createComplaint(residentId, complaint);
    }

    @GetMapping
    public List<ComplaintResponseDTO> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    @GetMapping("/{id}")
    public ComplaintResponseDTO getComplaintById(@PathVariable Long id) {
        return complaintService.getComplaintById(id);
    }

    @GetMapping("/resident/{residentId}")
    public List<ComplaintResponseDTO> getComplaintsByResident(
            @PathVariable Long residentId) {
        return complaintService.getComplaintsByResident(residentId);
    }

    @GetMapping("/status/{status}")
    public List<ComplaintResponseDTO> getComplaintsByStatus(
            @PathVariable String status) {
        return complaintService.getComplaintsByStatus(status);
    }

    @PutMapping("/{id}/status")
    public ComplaintResponseDTO changeStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return complaintService.changeStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
    }
}
