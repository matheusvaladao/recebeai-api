package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.CategoriaModel;
import com.recebeai.gestaoentregasapi.domain.model.Categoria;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CategoriaModel toDTO(Categoria categoria) {
        return modelMapper.map(categoria, CategoriaModel.class);
    }

    public List<CategoriaModel> toCollectionModel(List<Categoria> categorias) {
        return categorias.stream()
                .map(categoria -> toDTO(categoria))
                .collect(Collectors.toList());
    }
}
