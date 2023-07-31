package com.recebeai.gestaoentregasapi.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioInput {

    private String email;
    private String senha;
    private String nome;
    private String cpf;
    private String cep;
    private String endereco;
    private BigDecimal latitude;
    private BigDecimal longitude;

}
