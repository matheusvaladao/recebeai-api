package com.recebeai.gestaocomprasapi.api.assembler;

import com.recebeai.gestaocomprasapi.api.model.input.MarcaInput;
import com.recebeai.gestaocomprasapi.domain.model.Marca;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarcaDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Marca toDomainObject(MarcaInput marcaInput) {
        return modelMapper.map(marcaInput, Marca.class);
    }

}
