package com.gresidence.residence.Services;

import java.util.List;

import com.gresidence.residence.Dto.ApartmentRequestDTO;
import com.gresidence.residence.Dto.ApartmentResponseDTO;
public interface ApartmentService {
    ApartmentResponseDTO createApartment(ApartmentRequestDTO apartment);
    ApartmentResponseDTO updateApartment(Long id, ApartmentRequestDTO apartment);
    ApartmentResponseDTO getApartmentById(Long id);
    List<ApartmentResponseDTO> getAllApartments();
    void deleteApartment(Long id);
    List<ApartmentResponseDTO> getAvailableApartments();
    ApartmentResponseDTO changeStatus(Long id, String status);
    List<ApartmentResponseDTO> findByNumber(int number);
}

