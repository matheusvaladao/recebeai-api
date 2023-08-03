package com.recebeai.gestaoentregasapi.domain.service;

import com.recebeai.gestaoentregasapi.domain.model.FormaPagamento;
import com.recebeai.gestaoentregasapi.domain.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {

    private final FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    public FormaPagamentoService(FormaPagamentoRepository formaPagamentoRepository) {
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    public List<FormaPagamento> listarFormasPagamento() {
        return formaPagamentoRepository.findAll();
    }

    public Optional<FormaPagamento> encontrarPorId(Long id) {
        return formaPagamentoRepository.findById(id);
    }

    public FormaPagamento salvarFormaPagamento(FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento);
    }

    public void deletarFormaPagamento(Long id) {
        formaPagamentoRepository.deleteById(id);
    }

}

