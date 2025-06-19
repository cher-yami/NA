package com.ccstudent.msventa.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class InventarioDTO {
    private Long productoId;
    private Integer cantidadDisponible;
}