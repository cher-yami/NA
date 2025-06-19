package com.ccstudent.msproducto.feign;

import com.ccstudent.msproducto.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente", fallback = ClienteClientFallback.class)
public interface ClienteClient {
    @GetMapping("/clientes/{id}")
    ClienteDTO getCliente(@PathVariable("id") Long id);
}