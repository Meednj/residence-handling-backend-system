package com.gresidence.residence.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gresidence.residence.Dal.ComplaintRepository;
import com.gresidence.residence.Dal.ContractRepository;
import com.gresidence.residence.Dal.ResidentRepository;
import com.gresidence.residence.Entities.Complaint;
import com.gresidence.residence.Entities.Contract;
import com.gresidence.residence.Entities.Resident;
import com.gresidence.residence.Dto.ComplaintResponseDTO;
import com.gresidence.residence.Dto.ContractResponseDTO;
import com.gresidence.residence.Dto.ResidentRequestDTO;
import com.gresidence.residence.Dto.ResidentResponseDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;
    private final ContractRepository contractRepository;
    private final ComplaintRepository complaintRepository;
    private ResidentResponseDTO mapToDTO(Resident r) {
        return new ResidentResponseDTO(
            r.getId(),
            r.getCin(),
            r.getNom(),
            r.getPrenom(),
            r.getPhone(),
            r.getEmail()
        );
    }

    private ContractResponseDTO mapToDTO(Contract contract) {
        return new ContractResponseDTO(
                contract.getId(),
                contract.getStartDate(),
                contract.getEndDate(),
                contract.getActive(),
                contract.getMonthlyRent(),
                contract.getResident().getId(),
                contract.getApartment().getId());
    }

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
    public ResidentResponseDTO createResident(ResidentRequestDTO dto) {
        Resident resident = new Resident();
        resident.setCin(dto.getCin());
        resident.setNom(dto.getNom());
        resident.setPrenom(dto.getPrenom());
        resident.setPhone(dto.getPhone());
        resident.setEmail(dto.getEmail());
        return mapToDTO(residentRepository.save(resident));
    }

    @Override
    public ResidentResponseDTO updateResident(Long id, ResidentRequestDTO dto) {
        Resident resident = residentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Resident not found"));
        resident.setCin(dto.getCin());
        resident.setNom(dto.getNom());
        resident.setPrenom(dto.getPrenom());
        resident.setPhone(dto.getPhone());
        resident.setEmail(dto.getEmail());
        return mapToDTO(residentRepository.save(resident));
    }

    @Override
    public ResidentResponseDTO getResidentById(Long id) {
        Resident resident = residentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Resident not found"));
        return mapToDTO(resident);
    }

    @Override
    public List<ResidentResponseDTO> getAllResidents() {
        return residentRepository.findAll()
            .stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public void deleteResident(Long id) {
        if (!residentRepository.existsById(id)) {
            throw new RuntimeException("Resident not found");
        }
        residentRepository.deleteById(id);
    }

    @Override
    public List<ContractResponseDTO> getContractsOfResident(Long residentId) {
        if (!residentRepository.existsById(residentId)) {
            throw new RuntimeException("Resident not found");
        }
        return contractRepository.findByResidentId(residentId)
            .stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public List<ComplaintResponseDTO> getComplaintsOfResident(Long residentId) {
        if (!residentRepository.existsById(residentId)) {
            throw new RuntimeException("Resident not found");
        }
        return complaintRepository.findByResidentId(residentId)
            .stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public ResidentResponseDTO findResidentByCin(String cin) {
        Resident resident = residentRepository.findByCin(cin);
        if (resident == null) {
            throw new RuntimeException("Resident not found");
        }
        return mapToDTO(resident);
    }
}
