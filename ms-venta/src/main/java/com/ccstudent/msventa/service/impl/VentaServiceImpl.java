package com.ccstudent.msventa.service.impl;

import com.ccstudent.msventa.dto.DetalleVentaDTO;
import com.ccstudent.msventa.dto.VentaDTO;
import com.ccstudent.msventa.entity.DetalleVenta;
import com.ccstudent.msventa.entity.Venta;
import com.ccstudent.msventa.repository.DetalleVentaRepository;
import com.ccstudent.msventa.repository.VentaRepository;
import com.ccstudent.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepo;
    @Autowired
    private DetalleVentaRepository detalleRepo;

    private VentaDTO toDTO(Venta v) {
        List<DetalleVentaDTO> detalles = detalleRepo.findAllById(
                List.of() // implementación de consulta por venta
        ).stream().map(d -> DetalleVentaDTO.builder()
                .id(d.getId())
                .ventaId(d.getVenta().getId())
                .productoId(d.getProductoId())
                .cantidad(d.getCantidad())
                .descripcion(d.getDescripcion())
                .precioUnitario(d.getPrecioUnitario())
                .importe(d.getImporte())
                .build()).collect(Collectors.toList());
        return VentaDTO.builder()
                .id(v.getId())
                .fecha(v.getFecha())
                .subtotal(v.getSubtotal())
                .igv(v.getIgv())
                .total(v.getTotal())
                .detalles(detalles)
                .build();
    }

    @Override
    public List<VentaDTO> findAll() {
        return ventaRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public VentaDTO findById(Long id) {
        Venta v = ventaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        return toDTO(v);
    }

    @Override
    @Transactional
    public VentaDTO create(VentaDTO dto) {
        Venta v = Venta.builder()
                .fecha(dto.getFecha())
                .subtotal(dto.getSubtotal())
                .igv(dto.getIgv())
                .total(dto.getTotal())
                .build();
        Venta saved = ventaRepo.save(v);
        dto.getDetalles().forEach(dtoDet -> {
            DetalleVenta d = DetalleVenta.builder()
                    .venta(saved)
                    .productoId(dtoDet.getProductoId())
                    .cantidad(dtoDet.getCantidad())
                    .descripcion(dtoDet.getDescripcion())
                    .precioUnitario(dtoDet.getPrecioUnitario())
                    .importe(dtoDet.getImporte())
                    .build();
            detalleRepo.save(d);
        });
        return toDTO(saved);
    }

}
