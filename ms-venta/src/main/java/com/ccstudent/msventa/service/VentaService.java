package com.ccstudent.msventa.service;


import com.ccstudent.msventa.dto.VentaDTO;

import java.util.List;

public interface VentaService {
    List<VentaDTO> findAll();
    VentaDTO findById(Long id);
    VentaDTO create(VentaDTO dto);
}