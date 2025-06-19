package com.ccstudent.msinventario.repository;

import com.ccstudent.msinventario.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {

}