package com.ccstudent.msventa.feign;


import com.ccstudent.msventa.dto.FormaPagoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-pagos", fallback = PagosClientFallback.class)
public interface PagosClient {
    @GetMapping("/pagos/formas/{id}")
    FormaPagoDTO getFormaPago(@PathVariable("id") Long id);
}
