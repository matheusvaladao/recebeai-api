package com.recebeai.gestaocomprasapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@Data
public class Entrega {

    public Entrega(Long id, Date dataInicio, Date dataFim, BigDecimal valor) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataInicio;

    private Date dataFim;

    private BigDecimal valor;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Receptor receptor;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private FormaPagamento formaPagamento;

}
