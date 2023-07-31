package com.recebeai.gestaoentregasapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "receptores")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Receptor {

    public Receptor(Long id, Integer capacidade, String diasRecebimento) {
        this.id = id;
        this.capacidade = capacidade;
        this.diasRecebimento = diasRecebimento;
    }

    @Id
    @Column(name = "idreceptores")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer capacidade;

    private String diasRecebimento;

    @ManyToOne
    @JoinColumn(name = "usuarios_idusuarios")
    private Usuario usuario;

}
