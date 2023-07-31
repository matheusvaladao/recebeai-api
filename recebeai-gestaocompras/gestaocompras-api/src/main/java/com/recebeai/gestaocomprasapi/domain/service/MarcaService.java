package com.recebeai.gestaocomprasapi.domain.service;

import com.recebeai.gestaocomprasapi.domain.model.Marca;
import com.recebeai.gestaocomprasapi.domain.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> encontrarPorId(Long id) {
        return marcaRepository.findById(id);
    }

    public Marca salvarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void deletarMarca(Long id) {
        marcaRepository.deleteById(id);
    }

}
