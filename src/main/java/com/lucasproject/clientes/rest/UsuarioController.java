package com.lucasproject.clientes.rest;

import com.lucasproject.clientes.model.Usuario;
import com.lucasproject.clientes.repository.UsuarioRepository;
import com.lucasproject.clientes.rest.exception.UsuarioCadastradoException;
import com.lucasproject.clientes.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

   private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)// status 201 foi criado com sucesso
    public void salvar(@RequestBody @Valid Usuario usuario ){
        try{
            service.salvar(usuario);
        }catch(UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
