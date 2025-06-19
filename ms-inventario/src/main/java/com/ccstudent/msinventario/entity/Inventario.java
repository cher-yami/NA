package com.ccstudent.msinventario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventario")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Inventario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productoId;
    private Integer cantidad;
}