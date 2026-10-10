package com.gresidence.residence.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.gresidence.residence.Dto.ContractResponseDTO;
import com.gresidence.residence.Dto.ComplaintResponseDTO;
import com.gresidence.residence.Dto.ResidentRequestDTO;
import com.gresidence.residence.Dto.ResidentResponseDTO;
import com.gresidence.residence.Services.ResidentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/gresidence/residence/residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping
    public ResidentResponseDTO createResident(@RequestBody ResidentRequestDTO dto) {
        return residentService.createResident(dto);
    }

    @GetMapping
    public List<ResidentResponseDTO> getAllResidents() {
        return residentService.getAllResidents();
    }

    @GetMapping("/{id}")
    public ResidentResponseDTO getResidentById(@PathVariable Long id) {
        return residentService.getResidentById(id);
    }

    @PutMapping("/{id}")
    public ResidentResponseDTO updateResident(@PathVariable Long id, @RequestBody ResidentRequestDTO dto) {
        return residentService.updateResident(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteResident(@PathVariable Long id) {
        residentService.deleteResident(id);
    }

    @GetMapping("/{id}/contracts")
    public List<ContractResponseDTO> getContractsOfResident(@PathVariable Long id) {
        return residentService.getContractsOfResident(id);
    }

    @GetMapping("/{id}/complaints")
    public List<ComplaintResponseDTO> getComplaintsOfResident(@PathVariable Long id) {
        return residentService.getComplaintsOfResident(id);
    }

    @GetMapping("/cin/{cin}")
    public ResidentResponseDTO findResidentByCin(@PathVariable String cin) {
        return residentService.findResidentByCin(cin);
    }
}
