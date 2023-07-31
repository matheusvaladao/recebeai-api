package com.recebeai.gestaoentregasapi.api.model.input;

import lombok.Data;

@Data
public class ReceptorInput {

    private Integer capacidade;
    private String diasRecebimento;
    private Long idusuario;

}
