package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.ProdutoModel;
import com.recebeai.gestaoentregasapi.domain.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoModel toDTO(Produto produto) {
        var produtoModel = new ProdutoModel(
                produto.getId(),
                produto.getDescricao(),
                produto.getValor(),
                produto.getMarca().getId(),
                produto.getCategoria().getId()
        );
        return produtoModel;
    }

    public List<ProdutoModel> toCollectionModel(List<Produto> produtos) {
        return produtos.stream()
                .map(produto -> toDTO(produto))
                .collect(Collectors.toList());
    }
}
