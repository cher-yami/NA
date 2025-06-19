package com.ccstudent.msventa.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DetalleVentaDTO {
    private Long id;
    private Long ventaId;
    private Long productoId;
    private Integer cantidad;
    private String descripcion;
    private Double precioUnitario;
    private Double importe;
}