package com.lucasproject.clientes.repository;

import com.lucasproject.clientes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);

    //select count(*) >0 from usuario na tabela de usuário
    boolean existsByUsername(String username);
}
