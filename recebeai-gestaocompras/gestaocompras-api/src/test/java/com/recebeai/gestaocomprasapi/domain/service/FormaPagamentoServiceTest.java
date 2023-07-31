package com.recebeai.gestaocomprasapi.domain.service;

import com.recebeai.gestaocomprasapi.domain.model.FormaPagamento;
import com.recebeai.gestaocomprasapi.domain.repository.FormaPagamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FormaPagamentoServiceTest {

    @Mock
    private FormaPagamentoRepository formaPagamentoRepository;

    @InjectMocks
    private FormaPagamentoService formaPagamentoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarFormasPagamento() {
        List<FormaPagamento> formasPagamento = new ArrayList<>();
        formasPagamento.add(new FormaPagamento(1L, "Cartão de Crédito"));
        formasPagamento.add(new FormaPagamento(2L, "Boleto"));

        when(formaPagamentoRepository.findAll()).thenReturn(formasPagamento);

        List<FormaPagamento> resultado = formaPagamentoService.listarFormasPagamento();

        assertEquals(2, resultado.size());
    }

    @Test
    void testEncontrarPorId() {
        FormaPagamento formaPagamento = new FormaPagamento(1L, "Cartão de Crédito");

        when(formaPagamentoRepository.findById(1L)).thenReturn(Optional.of(formaPagamento));

        Optional<FormaPagamento> resultado = formaPagamentoService.encontrarPorId(1L);

        assertEquals(formaPagamento, resultado.get());
    }

    @Test
    void testSalvarFormaPagamento() {
        FormaPagamento formaPagamento = new FormaPagamento(null, "Boleto");
        FormaPagamento formaPagamentoSalva = new FormaPagamento(1L, "Boleto");

        when(formaPagamentoRepository.save(formaPagamento)).thenReturn(formaPagamentoSalva);

        FormaPagamento resultado = formaPagamentoService.salvarFormaPagamento(formaPagamento);

        assertEquals(formaPagamentoSalva, resultado);
    }

    @Test
    void testDeletarFormaPagamento() {
        Long idFormaPagamento = 1L;

        formaPagamentoService.deletarFormaPagamento(idFormaPagamento);

        verify(formaPagamentoRepository, times(1)).deleteById(idFormaPagamento);
    }
}
