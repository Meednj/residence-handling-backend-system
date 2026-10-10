package com.gresidence.residence.Dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComplaintResponseDTO {
    private Long id;
    private String type;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private Long residentId;
}
