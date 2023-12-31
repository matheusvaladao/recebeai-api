package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.FormaPagamentoModel;
import com.recebeai.gestaoentregasapi.domain.model.FormaPagamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FormaPagamentoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public FormaPagamentoModel toDTO(FormaPagamento formaPagamento) {
        return modelMapper.map(formaPagamento, FormaPagamentoModel.class);
    }

    public List<FormaPagamentoModel> toCollectionModel(List<FormaPagamento> formasPagamento) {
        return formasPagamento.stream()
                .map(formaPagamento -> toDTO(formaPagamento))
                .collect(Collectors.toList());
    }
}
