package com.ccstudent.mspagos.service.impl;

import com.ccstudent.mspagos.dto.FormaPagoDTO;
import com.ccstudent.mspagos.dto.TipoVentaDTO;
import com.ccstudent.mspagos.entity.FormaPago;
import com.ccstudent.mspagos.entity.TipoVenta;
import com.ccstudent.mspagos.repository.FormaPagoRepository;
import com.ccstudent.mspagos.repository.TipoVentaRepository;
import com.ccstudent.mspagos.service.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagosServiceImpl implements PagosService {

    @Autowired
    private FormaPagoRepository formaRepo;
    @Autowired private TipoVentaRepository tipoRepo;

    private FormaPagoDTO toDTO(FormaPago f) {
        return FormaPagoDTO.builder().id(f.getId()).descripcion(f.getDescripcion()).build();
    }
    private TipoVentaDTO toDTO(TipoVenta t) {
        return TipoVentaDTO.builder().id(t.getId()).descripcion(t.getDescripcion()).build();
    }

    @Override
    public List<FormaPagoDTO> listFormasPago() {
        return formaRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public FormaPagoDTO getFormaPago(Long id) {
        FormaPago f = formaRepo.findById(id).orElseThrow(() -> new RuntimeException("FormaPago no encontrada"));
        return toDTO(f);
    }

    @Override
    public List<TipoVentaDTO> listTiposVenta() {
        return tipoRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public TipoVentaDTO getTipoVenta(Long id) {
        TipoVenta t = tipoRepo.findById(id).orElseThrow(() -> new RuntimeException("TipoVenta no encontrada"));
        return toDTO(t);
    }
}