package com.recebeai.gestaocomprasapi.api.assembler;

import com.recebeai.gestaocomprasapi.api.model.input.CategoriaInput;
import com.recebeai.gestaocomprasapi.domain.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Categoria toDomainObject(CategoriaInput categoriaInput) {
        return modelMapper.map(categoriaInput, Categoria.class);
    }

}
