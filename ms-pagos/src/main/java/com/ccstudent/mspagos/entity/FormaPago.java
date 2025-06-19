package com.ccstudent.mspagos.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "forma_pago")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class FormaPago {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
}
