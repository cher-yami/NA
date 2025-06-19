package com.ccstudent.mspagos.service;

import com.ccstudent.mspagos.dto.FormaPagoDTO;
import com.ccstudent.mspagos.dto.TipoVentaDTO;

import java.util.List;

public interface PagosService {
    List<FormaPagoDTO> listFormasPago();
    FormaPagoDTO getFormaPago(Long id);
    List<TipoVentaDTO> listTiposVenta();
    TipoVentaDTO getTipoVenta(Long id);
}
