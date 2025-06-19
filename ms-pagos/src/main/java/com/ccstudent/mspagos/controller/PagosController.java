package com.ccstudent.mspagos.controller;

import com.ccstudent.mspagos.dto.FormaPagoDTO;
import com.ccstudent.mspagos.dto.TipoVentaDTO;
import com.ccstudent.mspagos.service.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagosController {

    @Autowired
    private PagosService service;

    @GetMapping("/formas")
    public List<FormaPagoDTO> formas() {
        return service.listFormasPago();
    }

    @GetMapping("/formas/{id}")
    public FormaPagoDTO forma(@PathVariable Long id) {
        return service.getFormaPago(id);
    }

    @GetMapping("/tipos")
    public List<TipoVentaDTO> tipos() {
        return service.listTiposVenta();
    }

    @GetMapping("/tipos/{id}")
    public TipoVentaDTO tipo(@PathVariable Long id) {
        return service.getTipoVenta(id);
    }
}
