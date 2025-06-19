package com.ccstudent.msventa.feign;

import com.ccstudent.msventa.dto.InventarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-inventario", fallback = InventarioClientFallback.class)
public interface InventarioClient {
    @GetMapping("/inventarios/producto/{id}")
    InventarioDTO getInventario(@PathVariable("id") Long productoId);
}
