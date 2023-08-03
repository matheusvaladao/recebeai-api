package com.recebeai.gestaoentregasapi.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataFim;

    private BigDecimal valor;
    private Long idProduto;
    private Long idReceptor;
    private Long idUsuario;
    private Long idFormaPagamento;

}
