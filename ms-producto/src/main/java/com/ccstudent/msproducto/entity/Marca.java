package com.ccstudent.msproducto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "marca")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Marca {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
}