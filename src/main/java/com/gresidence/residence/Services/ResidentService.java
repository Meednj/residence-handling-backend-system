package com.gresidence.residence.Services;

import java.util.List;

import com.gresidence.residence.Dto.ComplaintResponseDTO;
import com.gresidence.residence.Dto.ContractResponseDTO;
import com.gresidence.residence.Dto.ResidentRequestDTO;
import com.gresidence.residence.Dto.ResidentResponseDTO;
import com.gresidence.residence.Entities.Contract;
import com.gresidence.residence.Entities.Complaint;

public interface ResidentService {
    ResidentResponseDTO createResident(ResidentRequestDTO dto);
    ResidentResponseDTO updateResident(Long id, ResidentRequestDTO dto);
    ResidentResponseDTO getResidentById(Long id);
    List<ResidentResponseDTO> getAllResidents();
    void deleteResident(Long id);
    List<ContractResponseDTO> getContractsOfResident(Long residentId);
    List<ComplaintResponseDTO> getComplaintsOfResident(Long residentId);
    ResidentResponseDTO findResidentByCin(String cin);
}
