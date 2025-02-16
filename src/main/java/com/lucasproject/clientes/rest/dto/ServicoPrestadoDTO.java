package com.lucasproject.clientes.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoPrestadoDTO {

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @NotEmpty(message = "{campo.preco.obrigatorio}")
    private String preco;

    @NotEmpty(message = "{campo.data.obrigatorio}")
    private String data;

    @NotNull
    private Integer idCliente;

}
