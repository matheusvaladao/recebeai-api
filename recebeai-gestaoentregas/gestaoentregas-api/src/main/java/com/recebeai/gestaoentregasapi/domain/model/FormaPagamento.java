package com.recebeai.gestaoentregasapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "formas_pagamentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FormaPagamento {

    @Id
    @Column(name = "idformas_pagamentos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

}