package com.ccstudent.msproducto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "color")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Color {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
}