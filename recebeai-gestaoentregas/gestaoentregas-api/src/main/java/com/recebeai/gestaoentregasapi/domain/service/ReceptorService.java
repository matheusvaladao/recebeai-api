package com.recebeai.gestaoentregasapi.domain.service;

import com.recebeai.gestaoentregasapi.domain.model.Receptor;
import com.recebeai.gestaoentregasapi.domain.repository.ReceptorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptorService {

    private final ReceptorRepository receptorRepository;

    @Autowired
    public ReceptorService(ReceptorRepository receptorRepository) {
        this.receptorRepository = receptorRepository;
    }

    public List<Receptor> listarReceptores() {
        return receptorRepository.findAll();
    }

    public Optional<Receptor> encontrarPorId(Long id) {
        return receptorRepository.findById(id);
    }

    public Receptor salvarReceptor(Receptor receptor) {
        return receptorRepository.save(receptor);
    }

    public void deletarReceptor(Long id) {
        receptorRepository.deleteById(id);
    }

}
