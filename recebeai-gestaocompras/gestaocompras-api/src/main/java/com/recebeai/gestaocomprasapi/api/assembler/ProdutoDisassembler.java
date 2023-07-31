package com.recebeai.gestaocomprasapi.api.assembler;

import com.recebeai.gestaocomprasapi.api.model.input.ProdutoInput;
import com.recebeai.gestaocomprasapi.domain.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Produto toDomainObject(ProdutoInput produtoInput) {
        return modelMapper.map(produtoInput, Produto.class);
    }

}
