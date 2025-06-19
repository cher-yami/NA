package com.ccstudent.msventa.feign;

import com.ccstudent.msventa.dto.InventarioDTO;
import org.springframework.stereotype.Component;

@Component
public class InventarioClientFallback implements InventarioClient {
    @Override
    public InventarioDTO getInventario(Long productoId) {
        return InventarioDTO.builder().productoId(productoId).cantidadDisponible(0).build();
    }
}
