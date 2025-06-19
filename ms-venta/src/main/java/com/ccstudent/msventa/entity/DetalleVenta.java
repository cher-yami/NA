package com.ccstudent.msventa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_venta")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DetalleVenta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta;

    private Long productoId;
    private Integer cantidad;
    private String descripcion;
    private Double precioUnitario;
    private Double importe;
}