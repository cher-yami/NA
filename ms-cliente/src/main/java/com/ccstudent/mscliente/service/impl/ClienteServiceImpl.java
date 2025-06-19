package com.ccstudent.mscliente.service.impl;

import com.ccstudent.mscliente.dto.ClienteDTO;
import com.ccstudent.mscliente.entity.Cliente;
import com.ccstudent.mscliente.repository.ClienteRepository;
import com.ccstudent.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repo;

    private ClienteDTO toDTO(Cliente c) {
        return ClienteDTO.builder()
                .id(c.getId())
                .nombre(c.getNombre())
                .direccion(c.getDireccion())
                .telefono(c.getTelefono())
                .email(c.getEmail())
                .cuenta(c.getCuenta())
                .build();
    }

    @Override
    public List<ClienteDTO> findAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findById(Long id) {
        Cliente c = repo.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return toDTO(c);
    }

    @Override
    public ClienteDTO create(ClienteDTO dto) {
        Cliente c = Cliente.builder()
                .nombre(dto.getNombre())
                .direccion(dto.getDireccion())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .cuenta(dto.getCuenta())
                .build();
        return toDTO(repo.save(c));
    }

    @Override
    public ClienteDTO update(Long id, ClienteDTO dto) {
        Cliente c = repo.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        c.setNombre(dto.getNombre());
        c.setDireccion(dto.getDireccion());
        c.setTelefono(dto.getTelefono());
        c.setEmail(dto.getEmail());
        c.setCuenta(dto.getCuenta());
        return toDTO(repo.save(c));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}