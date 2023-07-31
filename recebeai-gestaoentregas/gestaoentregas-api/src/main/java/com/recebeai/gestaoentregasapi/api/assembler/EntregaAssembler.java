package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.EntregaModel;
import com.recebeai.gestaoentregasapi.domain.model.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntregaAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public EntregaModel toDTO(Entrega entrega) {
        return modelMapper.map(entrega, EntregaModel.class);
    }

    public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
        return entregas.stream()
                .map(entrega -> toDTO(entrega))
                .collect(Collectors.toList());
    }
}
