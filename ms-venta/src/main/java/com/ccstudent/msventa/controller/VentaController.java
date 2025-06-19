package com.ccstudent.msventa.controller;

import com.ccstudent.msventa.dto.VentaDTO;
import com.ccstudent.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService service;

    @GetMapping
    public List<VentaDTO> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public VentaDTO get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public VentaDTO create(@RequestBody VentaDTO dto) {
        return service.create(dto);
    }
}