package com.ccstudent.msventa.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "venta")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Venta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private Double subtotal;
    private Double igv;
    private Double total;
}
