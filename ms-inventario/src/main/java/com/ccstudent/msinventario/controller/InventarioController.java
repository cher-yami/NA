package com.ccstudent.msinventario.controller;

import com.ccstudent.msinventario.dto.InventarioDTO;
import com.ccstudent.msinventario.dto.InventarioRequestDTO;
import com.ccstudent.msinventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService service;

    @GetMapping
    public List<InventarioDTO> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public InventarioDTO get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public InventarioDTO create(@RequestBody InventarioRequestDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public InventarioDTO update(@PathVariable Long id, @RequestBody InventarioRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

