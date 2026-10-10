package com.gresidence.residence.Services;

import java.util.List;
import com.gresidence.residence.Dto.ContractRequestDTO;
import com.gresidence.residence.Dto.ContractResponseDTO;

public interface ContractService {
    ContractResponseDTO createContract(Long residentId, Long apartmentId, ContractRequestDTO dto);
    ContractResponseDTO updateContract(Long id, ContractRequestDTO dto);
    ContractResponseDTO getContractById(Long id);
    List<ContractResponseDTO> getAllContracts();
    ContractResponseDTO closeContract(Long id);
    List<ContractResponseDTO> getContractsByResident(Long residentId);
    List<ContractResponseDTO> getContractsByApartment(Long apartmentId);

    List<ContractResponseDTO> getActiveContracts();
    void deleteContract(Long id);
}
