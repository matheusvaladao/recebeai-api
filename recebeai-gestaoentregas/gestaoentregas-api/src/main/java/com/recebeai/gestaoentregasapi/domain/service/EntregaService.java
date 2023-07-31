package com.recebeai.gestaoentregasapi.domain.service;

import com.recebeai.gestaoentregasapi.domain.model.Entrega;
import com.recebeai.gestaoentregasapi.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;

    @Autowired
    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    public Optional<Entrega> encontrarPorId(Long id) {
        return entregaRepository.findById(id);
    }

    public Entrega salvarEntrega(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    public void deletarEntrega(Long id) {
        entregaRepository.deleteById(id);
    }

}
