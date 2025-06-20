package com.ccstudent.msventa.feign;

import com.ccstudent.msventa.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-producto", fallback = ProductoClientFallback.class)
public interface ProductoClient {
    @GetMapping("/productos/{id}")
    ProductoDTO getProducto(@PathVariable("id") Long id);
}
