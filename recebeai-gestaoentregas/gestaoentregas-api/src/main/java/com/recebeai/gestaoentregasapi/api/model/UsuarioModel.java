package com.recebeai.gestaoentregasapi.api.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UsuarioModel {

    private Long id;
    private String email;
    private String senha;
    private String nome;
    private String cpf;
    private String cep;
    private String endereco;
    private BigDecimal latitude;
    private BigDecimal longitude;

}
