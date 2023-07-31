package com.recebeai.gestaoentregasapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "produtos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {

    public Produto(Long id, String descricao, BigDecimal valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    @Id
    @Column(name = "idprodutos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "marcas_idmarcas")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "categorias_idcategorias")
    private Categoria categoria;

}
