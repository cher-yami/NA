package com.ccstudent.msproducto.service.impl;

import com.ccstudent.msproducto.dto.ProductoDTO;
import com.ccstudent.msproducto.entity.Producto;
import com.ccstudent.msproducto.repository.ProductoRepository;
import com.ccstudent.msproducto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repo;

    private ProductoDTO toDTO(Producto p) {
        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .descripcion(p.getDescripcion())
                .stock(p.getStock())
                .precio(p.getPrecio())
                .build();
    }

    @Override
    public List<ProductoDTO> findAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductoDTO findById(Long id) {
        Producto p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return toDTO(p);
    }

    @Override
    public ProductoDTO create(ProductoDTO dto) {
        Producto p = Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .stock(dto.getStock())
                .precio(dto.getPrecio())
                .build();
        return toDTO(repo.save(p));
    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO dto) {
        Producto p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setStock(dto.getStock());
        p.setPrecio(dto.getPrecio());
        return toDTO(repo.save(p));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}