package com.gresidence.residence.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResidentResponseDTO {
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private String phone;
    private String email;
}
