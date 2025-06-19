package com.ccstudent.msproducto.feign;

import com.ccstudent.msproducto.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteClientFallback implements ClienteClient {
    @Override
    public ClienteDTO getCliente(Long id) {
        return new ClienteDTO(id, "DESCONOCIDO", "00000000");
    }
}