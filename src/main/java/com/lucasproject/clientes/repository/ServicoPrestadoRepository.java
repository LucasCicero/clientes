package com.lucasproject.clientes.repository;

import com.lucasproject.clientes.model.Cliente;
import com.lucasproject.clientes.model.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
   @Query(" select s from ServicoPerstao s join s.cliente c where upper(c.nome) like upper(:nome) and MONTH(s.data)=:mes ")
    List<ServicoPrestado> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);
}
