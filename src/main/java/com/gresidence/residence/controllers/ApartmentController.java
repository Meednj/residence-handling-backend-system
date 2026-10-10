package com.gresidence.residence.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.gresidence.residence.Dto.ApartmentRequestDTO;
import com.gresidence.residence.Dto.ApartmentResponseDTO;
import com.gresidence.residence.Entities.Apartment;
import com.gresidence.residence.Services.ApartmentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/gresidence/residence/apartments")
public class ApartmentController {

    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @PostMapping
    public ApartmentResponseDTO createApartment(
            @RequestBody ApartmentRequestDTO apartment) {
        return apartmentService.createApartment(apartment);
    }

    @GetMapping
    public List<ApartmentResponseDTO> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @PutMapping("/{id}")
    public ApartmentResponseDTO updateApartment(
            @PathVariable Long id,
            @RequestBody ApartmentRequestDTO apartment) {
        return apartmentService.updateApartment(id, apartment);
    }

    @GetMapping("/{id}")
    public ApartmentResponseDTO getApartmentById(@PathVariable Long id) {
        return apartmentService.getApartmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable Long id) {
        apartmentService.deleteApartment(id);
    }

    @GetMapping("/available")
    public List<ApartmentResponseDTO> getAvailableApartments() {
        return apartmentService.getAvailableApartments();
    }

    @PutMapping("/{id}/status")
    public ApartmentResponseDTO changeStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return apartmentService.changeStatus(id, status);
    }

    @GetMapping("/number")
    public List<ApartmentResponseDTO> findByNumber(@RequestParam int number) {
        return apartmentService.findByNumber(number);
    }
}
