package com.recebeai.gestaocomprasapi.api.assembler;

import com.recebeai.gestaocomprasapi.api.model.input.ReceptorInput;
import com.recebeai.gestaocomprasapi.domain.model.Receptor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceptorDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Receptor toDomainObject(ReceptorInput receptorInput) {
        return modelMapper.map(receptorInput, Receptor.class);
    }

}
