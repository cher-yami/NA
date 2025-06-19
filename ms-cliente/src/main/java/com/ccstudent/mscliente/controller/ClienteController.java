package com.ccstudent.mscliente.controller;

import com.ccstudent.mscliente.dto.ClienteDTO;
import com.ccstudent.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteDTO> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClienteDTO get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ClienteDTO create(@RequestBody ClienteDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public ClienteDTO update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
