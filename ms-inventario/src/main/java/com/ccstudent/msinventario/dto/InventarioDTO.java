package com.ccstudent.msinventario.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class InventarioDTO {
    private Long id;
    private Long productoId;
    private Integer cantidad;
}