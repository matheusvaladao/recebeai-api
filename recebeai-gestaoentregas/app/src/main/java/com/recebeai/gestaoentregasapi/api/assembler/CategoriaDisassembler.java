package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.input.CategoriaInput;
import com.recebeai.gestaoentregasapi.domain.model.Categoria;
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
