package com.ccstudent.msventa.feign;

import com.ccstudent.msventa.dto.FormaPagoDTO;
import org.springframework.stereotype.Component;

@Component
public class PagosClientFallback implements PagosClient {
    @Override
    public FormaPagoDTO getFormaPago(Long id) {
        return FormaPagoDTO.builder().id(id).descripcion("DESCONOCIDO").build();
    }
}
