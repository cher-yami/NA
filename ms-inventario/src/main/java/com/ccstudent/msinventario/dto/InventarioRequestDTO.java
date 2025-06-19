package com.ccstudent.msinventario.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class InventarioRequestDTO {
    private Long productoId;
    private Integer cantidad;
}