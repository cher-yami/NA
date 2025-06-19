package com.ccstudent.mscliente.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String cuenta;
}