package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.input.FormaPagamentoInput;
import com.recebeai.gestaoentregasapi.domain.model.FormaPagamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormaPagamentoDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public FormaPagamento toDomainObject(FormaPagamentoInput formaPagamentoInput) {
        return modelMapper.map(formaPagamentoInput, FormaPagamento.class);
    }

}
