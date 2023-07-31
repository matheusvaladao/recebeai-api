package com.recebeai.gestaoentregasapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "categorias")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categoria {

    @Id
    @Column(name = "idcategorias")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

}
