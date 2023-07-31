package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.ReceptorModel;
import com.recebeai.gestaoentregasapi.domain.model.Receptor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReceptorAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ReceptorModel toDTO(Receptor receptor) {
        return modelMapper.map(receptor, ReceptorModel.class);
    }

    public List<ReceptorModel> toCollectionModel(List<Receptor> receptores) {
        return receptores.stream()
                .map(receptor -> toDTO(receptor))
                .collect(Collectors.toList());
    }
}
