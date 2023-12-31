package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.MarcaModel;
import com.recebeai.gestaoentregasapi.domain.model.Marca;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarcaAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public MarcaModel toDTO(Marca marca) {
        return modelMapper.map(marca, MarcaModel.class);
    }

    public List<MarcaModel> toCollectionModel(List<Marca> marcas) {
        return marcas.stream()
                .map(marca -> toDTO(marca))
                .collect(Collectors.toList());
    }
}
