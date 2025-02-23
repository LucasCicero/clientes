package com.lucasproject.clientes.rest;

import com.lucasproject.clientes.model.Usuario;
import com.lucasproject.clientes.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)// status 201 foi criado com sucesso
    public void salvar(@RequestBody @Valid Usuario usuario ){
       repository.save(usuario);
    }
}
