package com.ccstudent.msventa.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String dni;
}