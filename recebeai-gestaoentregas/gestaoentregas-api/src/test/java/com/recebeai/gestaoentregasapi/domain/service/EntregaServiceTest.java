package com.recebeai.gestaoentregasapi.domain.service;

import com.recebeai.gestaoentregasapi.domain.model.Entrega;
import com.recebeai.gestaoentregasapi.domain.model.Receptor;
import com.recebeai.gestaoentregasapi.domain.model.Usuario;
import com.recebeai.gestaoentregasapi.domain.repository.EntregaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EntregaServiceTest {

    @Mock
    private EntregaRepository entregaRepository;

    @Mock
    private EnviaNotificacaoService enviaNotificacaoService;

    @InjectMocks
    private EntregaService entregaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarEntregas() {
        List<Entrega> entregas = new ArrayList<>();
        entregas.add(new Entrega(1L, parseDate("2023-07-29"), parseDate("2023-07-30"), new BigDecimal(100.00)));

        when(entregaRepository.findAll()).thenReturn(entregas);

        List<Entrega> resultado = entregaService.listarEntregas();

        assertEquals(1, resultado.size());
    }

    @Test
    void testEncontrarPorId() {
        Entrega entrega = new Entrega(1L, parseDate("2023-07-29"), parseDate("2023-07-30"), new BigDecimal(100.00));

        when(entregaRepository.findById(1L)).thenReturn(Optional.of(entrega));

        Optional<Entrega> resultado = entregaService.encontrarPorId(1L);

        assertEquals(entrega, resultado.get());
    }

    @Test
    public void testSalvarEntrega() {

        Usuario usuario = new Usuario(1L, "usuario1@example.com", "senha123", "Usuario 1", "12345678901", "12345678", "Rua A", new BigDecimal(10.12345678), new BigDecimal(-20.12345678));

        Receptor receptor = new Receptor(null, 300, "Sexta, Sábado", usuario);

        Entrega entrega = new Entrega(1L, parseDate("2023-07-29"), parseDate("2023-07-30"), new BigDecimal(100.00), receptor, usuario);

        when(entregaRepository.save(any(Entrega.class))).thenReturn(entrega);

        Entrega entregaSalva = entregaService.salvarEntrega(entrega);

        verify(entregaRepository).save(entrega);

        verify(enviaNotificacaoService).send(entrega.getReceptor().getUsuario().getEmail());

        assertEquals(entrega, entregaSalva);
    }


    @Test
    void testDeletarEntrega() {
        Long idEntrega = 1L;

        entregaService.deletarEntrega(idEntrega);

        verify(entregaRepository, times(1)).deleteById(idEntrega);
    }

    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
