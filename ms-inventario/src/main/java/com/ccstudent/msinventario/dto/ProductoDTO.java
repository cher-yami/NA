package com.ccstudent.msinventario.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Double precio;
}