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
    private final EnviaNotificacaoService enviaNotificacaoService;

    @Autowired
    public EntregaService(EntregaRepository entregaRepository, EnviaNotificacaoService enviaNotificacaoService) {
        this.entregaRepository = entregaRepository;
        this.enviaNotificacaoService = enviaNotificacaoService;
    }

    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    public Optional<Entrega> encontrarPorId(Long id) {
        return entregaRepository.findById(id);
    }

    public Entrega salvarEntrega(Entrega entrega) {
        Entrega novaEntrega = entregaRepository.save(entrega);
        enviaNotificacaoService.send(novaEntrega.getReceptor().getUsuario().getEmail());
        return novaEntrega;
    }

    public void deletarEntrega(Long id) {
        entregaRepository.deleteById(id);
    }

}
