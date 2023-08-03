package com.recebeai.gestaoentregasapi.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceptorInput {

    private Integer capacidade;
    private String diasRecebimento;
    private Long idUsuario;

}
