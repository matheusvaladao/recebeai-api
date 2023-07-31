package com.recebeai.gestaoentregasapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "entregas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entrega {

    public Entrega(Long id, Date dataInicio, Date dataFim, BigDecimal valor) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }

    @Id
    @Column(name = "identregas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "produtos_idprodutos")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "receptores_idreceptores")
    private Receptor receptor;

    @ManyToOne
    @JoinColumn(name = "usuarios_idusuarios")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "formas_pagamentos_idformas_pagamentos")
    private FormaPagamento formaPagamento;

}
