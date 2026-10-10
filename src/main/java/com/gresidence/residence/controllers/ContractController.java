package com.gresidence.residence.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.gresidence.residence.Dto.ContractRequestDTO;
import com.gresidence.residence.Dto.ContractResponseDTO;
import com.gresidence.residence.Services.ContractService;

@RestController
@RequestMapping("/gresidence/residence/contracts")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping
    public ContractResponseDTO createContract(@RequestParam Long residentId,
                                              @RequestParam Long apartmentId,
                                              @RequestBody ContractRequestDTO dto) {
        return contractService.createContract(residentId, apartmentId, dto);
    }

    @GetMapping
    public List<ContractResponseDTO> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public ContractResponseDTO getContractById(@PathVariable Long id) {
        return contractService.getContractById(id);
    }

    @PutMapping("/{id}")
    public ContractResponseDTO updateContract(@PathVariable Long id,
                                              @RequestBody ContractRequestDTO dto) {
        return contractService.updateContract(id, dto);
    }

    @PutMapping("/{id}/close")
    public ContractResponseDTO closeContract(@PathVariable Long id) {
        return contractService.closeContract(id);
    }

    @GetMapping("/resident/{residentId}")
    public List<ContractResponseDTO> getContractsByResident(@PathVariable Long residentId) {
        return contractService.getContractsByResident(residentId);
    }

    @GetMapping("/apartment/{apartmentId}")
    public List<ContractResponseDTO> getContractsByApartment(@PathVariable Long apartmentId) {
        return contractService.getContractsByApartment(apartmentId);
    }

    @GetMapping("/active")
    public List<ContractResponseDTO> getActiveContracts() {
        return contractService.getActiveContracts();
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
    }
}
