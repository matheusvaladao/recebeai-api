package com.recebeai.gestaoentregasapi.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntregaInput {

    private Date dataInicio;
    private Date dataFim;
    private BigDecimal valor;
    private Long idproduto;
    private Long idreceptor;
    private Long idusuario;
    private Long idFormaPagamento;

}
