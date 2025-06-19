package com.ccstudent.msinventario.service.impl;

import com.ccstudent.msinventario.dto.InventarioDTO;
import com.ccstudent.msinventario.dto.InventarioRequestDTO;
import com.ccstudent.msinventario.entity.Inventario;
import com.ccstudent.msinventario.repository.InventarioRepository;
import com.ccstudent.msinventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository repo;

    private InventarioDTO toDTO(Inventario inv) {
        return InventarioDTO.builder()
                .id(inv.getId())
                .productoId(inv.getProductoId())
                .cantidad(inv.getCantidad())
                .build();
    }

    @Override
    public List<InventarioDTO> findAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public InventarioDTO findById(Long id) {
        Inventario inv = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
        return toDTO(inv);
    }

    @Override
    @Transactional
    public InventarioDTO create(InventarioRequestDTO dto) {
        Inventario inv = Inventario.builder()
                .productoId(dto.getProductoId())
                .cantidad(dto.getCantidad())
                .build();
        return toDTO(repo.save(inv));
    }

    @Override
    @Transactional
    public InventarioDTO update(Long id, InventarioRequestDTO dto) {
        Inventario inv = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
        inv.setProductoId(dto.getProductoId());
        inv.setCantidad(dto.getCantidad());
        return toDTO(repo.save(inv));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
