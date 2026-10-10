package com.gresidence.residence.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gresidence.residence.Dal.ApartmentRepository;
import com.gresidence.residence.Dal.ContractRepository;
import com.gresidence.residence.Dal.ResidentRepository;
import com.gresidence.residence.Dto.ContractRequestDTO;
import com.gresidence.residence.Dto.ContractResponseDTO;
import com.gresidence.residence.Entities.Apartment;
import com.gresidence.residence.Entities.Contract;
import com.gresidence.residence.Entities.Resident;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ResidentRepository residentRepository;
    private final ApartmentRepository apartmentRepository;

    private ContractResponseDTO mapToDTO(Contract contract) {
        return new ContractResponseDTO(
            contract.getId(),
            contract.getStartDate(),
            contract.getEndDate(),
            contract.getActive(),
            contract.getMonthlyRent(),
            contract.getResident().getId(),
            contract.getApartment().getId()
        );
    }


    @Override
    public ContractResponseDTO createContract(Long residentId, Long apartmentId, ContractRequestDTO dto) {
        Resident resident = residentRepository.findById(residentId)
            .orElseThrow(() -> new RuntimeException("Resident not found"));
        Apartment apartment = apartmentRepository.findById(apartmentId)
            .orElseThrow(() -> new RuntimeException("Apartment not found"));

        Contract contract = new Contract();
        contract.setStartDate(dto.getStartDate());
        contract.setEndDate(dto.getEndDate());
        contract.setMonthlyRent(dto.getMonthlyRent());
        contract.setActive(true);
        contract.setResident(resident);
        contract.setApartment(apartment);

        return mapToDTO(contractRepository.save(contract));
    }

    @Override
    public ContractResponseDTO updateContract(Long id, ContractRequestDTO dto) {
        Contract contract = contractRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Contract not found"));
        contract.setStartDate(dto.getStartDate());
        contract.setEndDate(dto.getEndDate());
        contract.setMonthlyRent(dto.getMonthlyRent());
        return mapToDTO(contractRepository.save(contract));
    }

    @Override
    public ContractResponseDTO getContractById(Long id) {
        Contract contract = contractRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Contract not found"));
        return mapToDTO(contract);
    }

    @Override
    public List<ContractResponseDTO> getAllContracts() {
        return contractRepository.findAll().stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public ContractResponseDTO closeContract(Long id) {
        Contract contract = contractRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Contract not found"));
        contract.setActive(false);
        return mapToDTO(contractRepository.save(contract));
    }

    @Override
    public List<ContractResponseDTO> getContractsByResident(Long residentId) {
        if (!residentRepository.existsById(residentId)) {
            throw new RuntimeException("Resident not found");
        }
        return contractRepository.findByResidentId(residentId).stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public List<ContractResponseDTO> getContractsByApartment(Long apartmentId) {
        if (!apartmentRepository.existsById(apartmentId)) {
            throw new RuntimeException("Apartment not found");
        }
        return contractRepository.findByApartmentId(apartmentId).stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public List<ContractResponseDTO> getActiveContracts() {
        return contractRepository.findByActiveTrue().stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public void deleteContract(Long id) {
        if (!contractRepository.existsById(id)) {
            throw new RuntimeException("Contract not found");
        }
        contractRepository.deleteById(id);
    }
}