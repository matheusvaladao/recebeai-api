package com.recebeai.gestaoentregasapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntregaModel {

    private Long id;
    private Date dataInicio;
    private Date dataFim;
    private BigDecimal valor;
    private Long idproduto;
    private Long idreceptor;
    private Long idusuario;
    private Long idFormaPagamento;

}
