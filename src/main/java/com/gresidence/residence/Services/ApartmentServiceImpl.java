package com.gresidence.residence.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gresidence.residence.Dal.ApartmentRepository;
import com.gresidence.residence.Dto.ApartmentRequestDTO;
import com.gresidence.residence.Dto.ApartmentResponseDTO;
import com.gresidence.residence.Entities.Apartment;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;

    private ApartmentResponseDTO mapToDTO(Apartment a) {
        return new ApartmentResponseDTO(
            a.getId(),
            a.getNumber(),
            a.getFloor(),
            a.getRooms(),
            a.getRent(),
            a.getStatus()
        );
    }

    @Override
    public ApartmentResponseDTO createApartment(ApartmentRequestDTO dto) {
        Apartment apartment = new Apartment();
        apartment.setNumber(dto.getNumber());
        apartment.setFloor(dto.getFloor());
        apartment.setRooms(dto.getRooms());
        apartment.setRent(dto.getRent());
        apartment.setStatus(dto.getStatus());

        return mapToDTO(apartmentRepository.save(apartment));
    }

    @Override
    public ApartmentResponseDTO updateApartment(Long id, ApartmentRequestDTO dto) {
        Apartment apartment = apartmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Apartment not found"));

        apartment.setNumber(dto.getNumber());
        apartment.setFloor(dto.getFloor());
        apartment.setRooms(dto.getRooms());
        apartment.setRent(dto.getRent());
        apartment.setStatus(dto.getStatus());

        return mapToDTO(apartmentRepository.save(apartment));
    }

    @Override
    public ApartmentResponseDTO getApartmentById(Long id) {
        return apartmentRepository.findById(id)
            .map(this::mapToDTO)
            .orElseThrow(() -> new RuntimeException("Apartment not found"));
    }

    @Override
    public List<ApartmentResponseDTO> getAllApartments() {
        return apartmentRepository.findAll()
            .stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public void deleteApartment(Long id) {
        if (!apartmentRepository.existsById(id)) {
            throw new RuntimeException("Apartment not found");
        }
        apartmentRepository.deleteById(id);
    }

    @Override
    public List<ApartmentResponseDTO> getAvailableApartments() {
        return apartmentRepository.findByStatus("AVAILABLE")
            .stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public ApartmentResponseDTO changeStatus(Long id, String status) {
        Apartment apartment = apartmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Apartment not found"));

        apartment.setStatus(status);
        return mapToDTO(apartmentRepository.save(apartment));
    }

    @Override
    public List<ApartmentResponseDTO> findByNumber(int number) {
        return apartmentRepository.findByNumber(number)
            .stream()
            .map(this::mapToDTO)
            .toList();
    }
}
