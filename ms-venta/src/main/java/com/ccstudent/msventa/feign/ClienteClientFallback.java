package com.ccstudent.msventa.feign;

import com.ccstudent.msventa.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteClientFallback implements ClienteClient {
    @Override
    public ClienteDTO getCliente(Long id) {
        return ClienteDTO.builder().id(id).nombre("DESCONOCIDO").dni("00000000").build();
    }
}