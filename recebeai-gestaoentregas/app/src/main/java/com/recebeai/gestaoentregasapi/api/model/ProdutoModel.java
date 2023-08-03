package com.recebeai.gestaoentregasapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoModel {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private Long idMarca;
    private Long idCategoria;

}
