package com.ccstudent.msproducto.controller;

import com.ccstudent.msproducto.dto.ProductoDTO;
import com.ccstudent.msproducto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<ProductoDTO> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductoDTO get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ProductoDTO create(@RequestBody ProductoDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ProductoDTO update(@PathVariable Long id, @RequestBody ProductoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}