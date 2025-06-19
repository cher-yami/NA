package com.ccstudent.msinventario.service;

import com.ccstudent.msinventario.dto.InventarioDTO;
import com.ccstudent.msinventario.dto.InventarioRequestDTO;

import java.util.List;

public interface InventarioService {
    List<InventarioDTO> findAll();
    InventarioDTO findById(Long id);
    InventarioDTO create(InventarioRequestDTO dto);
    InventarioDTO update(Long id, InventarioRequestDTO dto);
    void delete(Long id);
}
