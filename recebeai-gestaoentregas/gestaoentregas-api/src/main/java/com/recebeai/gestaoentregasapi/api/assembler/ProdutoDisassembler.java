package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.input.ProdutoInput;
import com.recebeai.gestaoentregasapi.domain.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Produto toDomainObject(ProdutoInput produtoInput) {

        var produto = new Produto();
        produto.setDescricao(produtoInput.getDescricao());
        produto.setValor(produtoInput.getValor());

        return produto;
    }

}
