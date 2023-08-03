package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.input.EntregaInput;
import com.recebeai.gestaoentregasapi.domain.model.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntregaDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Entrega toDomainObject(EntregaInput entregaInput) {
        var entrega = new Entrega();
        entrega.setDataInicio(entregaInput.getDataInicio());
        entrega.setDataFim(entregaInput.getDataFim());
        entrega.setValor(entregaInput.getValor());
        return entrega;
    }

}
