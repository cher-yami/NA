package com.ccstudent.msinventario.feign;

import com.ccstudent.msinventario.dto.ProductoDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductoClientFallback implements ProductoClient {
    @Override
    public ProductoDTO getProducto(Long id) {
        return ProductoDTO.builder().id(id).nombre("DESCONOCIDO").precio(0.0).build();
    }
}
