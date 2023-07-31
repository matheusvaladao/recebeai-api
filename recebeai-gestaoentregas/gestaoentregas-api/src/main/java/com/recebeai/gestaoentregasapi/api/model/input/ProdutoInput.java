package com.recebeai.gestaoentregasapi.api.model.input;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoInput {

    private String descricao;
    private BigDecimal valor;
    private Long idmarca;
    private Long idcategoria;

}
