package com.recebeai.gestaoentregasapi.api.model;

import lombok.Data;

@Data
public class ReceptorModel {

    private Long id;
    private Integer capacidade;
    private String diasRecebimento;
    private Long idusuario;

}
