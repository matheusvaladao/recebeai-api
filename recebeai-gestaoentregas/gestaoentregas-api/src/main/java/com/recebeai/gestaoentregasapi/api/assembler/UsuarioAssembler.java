package com.recebeai.gestaoentregasapi.api.assembler;

import com.recebeai.gestaoentregasapi.api.model.UsuarioModel;
import com.recebeai.gestaoentregasapi.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioModel toDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    public List<UsuarioModel> toCollectionModel(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(usuario -> toDTO(usuario))
                .collect(Collectors.toList());
    }
}
