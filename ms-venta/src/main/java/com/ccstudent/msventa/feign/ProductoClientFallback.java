package com.ccstudent.msventa.feign;

import com.ccstudent.msventa.dto.ProductoDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductoClientFallback implements ProductoClient {
    @Override
    public ProductoDTO getProducto(Long id) {
        return ProductoDTO.builder().id(id).nombre("DESCONOCIDO").precioVenta(0.0).build();
    }
}