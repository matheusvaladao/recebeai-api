package com.recebeai.gestaoentregasapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceptorModel {

    private Long id;
    private Integer capacidade;
    private String diasRecebimento;
    private Long idUsuario;

}
