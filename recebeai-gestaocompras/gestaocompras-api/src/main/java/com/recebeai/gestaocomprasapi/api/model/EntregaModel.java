package com.recebeai.gestaocomprasapi.api.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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
