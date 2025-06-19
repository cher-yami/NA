package com.ccstudent.msproducto.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer stock;
    private Double precio;
}