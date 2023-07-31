package com.recebeai.gestaocomprasapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@Data
public class Receptor {

    public Receptor(Long id, Integer capacidade, String diasRecebimento) {
        this.id = id;
        this.capacidade = capacidade;
        this.diasRecebimento = diasRecebimento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer capacidade;

    private String diasRecebimento;

    @ManyToOne
    private Usuario usuario;

}
