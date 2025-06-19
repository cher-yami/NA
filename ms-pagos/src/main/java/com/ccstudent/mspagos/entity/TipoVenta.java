package com.ccstudent.mspagos.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_venta")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TipoVenta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
}