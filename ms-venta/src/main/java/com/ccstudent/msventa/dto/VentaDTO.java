package com.ccstudent.msventa.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class VentaDTO {
    private Long id;
    private LocalDateTime fecha;
    private Double subtotal;
    private Double igv;
    private Double total;
    private List<DetalleVentaDTO> detalles;
}