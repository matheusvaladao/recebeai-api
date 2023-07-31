package com.recebeai.gestaoentregasapi.api.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoModel {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private Long idmarca;
    private Long idcategoria;

}
