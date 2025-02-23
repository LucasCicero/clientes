package com.lucasproject.clientes.repository;

import com.lucasproject.clientes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
