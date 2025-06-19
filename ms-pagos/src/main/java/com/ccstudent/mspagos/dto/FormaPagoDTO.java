package com.ccstudent.mspagos.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class FormaPagoDTO {
    private Long id;
    private String descripcion;
}
