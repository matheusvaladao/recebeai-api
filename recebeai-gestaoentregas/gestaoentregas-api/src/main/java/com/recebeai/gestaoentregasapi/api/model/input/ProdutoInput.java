package com.recebeai.gestaoentregasapi.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoInput {

    private String descricao;
    private BigDecimal valor;
    private Long idmarca;
    private Long idcategoria;

}
