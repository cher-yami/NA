package com.ccstudent.msproducto.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "conectividad")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Conectividad {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
}