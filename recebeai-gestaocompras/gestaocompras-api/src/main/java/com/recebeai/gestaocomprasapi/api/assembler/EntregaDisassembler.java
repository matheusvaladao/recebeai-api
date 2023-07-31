package com.recebeai.gestaocomprasapi.api.assembler;

import com.recebeai.gestaocomprasapi.api.model.input.EntregaInput;
import com.recebeai.gestaocomprasapi.domain.model.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntregaDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Entrega toDomainObject(EntregaInput entregaInput) {
        return modelMapper.map(entregaInput, Entrega.class);
    }

}
