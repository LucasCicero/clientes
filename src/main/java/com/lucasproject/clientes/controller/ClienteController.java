package com.lucasproject.clientes.controller;

import com.lucasproject.clientes.model.Cliente;
import com.lucasproject.clientes.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {


    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> obterTodos(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> salvar(@RequestBody @Valid Cliente cliente){
        repository.save(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> acharPorId(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)));

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
       repository
               .findById(id)
               .map(cliente->{
                   repository.delete(cliente);
                   return Void.TYPE;
               })
               .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable("id") Integer id, @RequestBody @Valid Cliente clienteAtualizado){
        repository
                .findById(id)
                .map(cliente->{
                   cliente.setNome(clienteAtualizado.getNome());
                    cliente.setCpf(clienteAtualizado.getCpf());
                    return repository.save(clienteAtualizado);
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }
}
