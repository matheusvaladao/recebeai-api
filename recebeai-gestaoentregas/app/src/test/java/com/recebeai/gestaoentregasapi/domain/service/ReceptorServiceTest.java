package com.recebeai.gestaoentregasapi.domain.service;

import com.recebeai.gestaoentregasapi.domain.model.Receptor;
import com.recebeai.gestaoentregasapi.domain.repository.ReceptorRepository;
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

class ReceptorServiceTest {

    @Mock
    private ReceptorRepository receptorRepository;

    @InjectMocks
    private ReceptorService receptorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarReceptores() {
        List<Receptor> receptores = new ArrayList<>();
        receptores.add(new Receptor(1L, 100, "Segunda, Terça"));
        receptores.add(new Receptor(2L, 200, "Quarta, Quinta"));

        when(receptorRepository.findAll()).thenReturn(receptores);

        List<Receptor> resultado = receptorService.listarReceptores();

        assertEquals(2, resultado.size());
    }

    @Test
    void testEncontrarPorId() {
        Receptor receptor = new Receptor(1L, 100, "Segunda, Terça");

        when(receptorRepository.findById(1L)).thenReturn(Optional.of(receptor));

        Optional<Receptor> resultado = receptorService.encontrarPorId(1L);

        assertEquals(receptor, resultado.get());
    }

    @Test
    void testSalvarReceptor() {
        Receptor receptor = new Receptor(null, 300, "Sexta, Sábado");
        Receptor receptorSalvo = new Receptor(3L, 300, "Sexta, Sábado");

        when(receptorRepository.save(receptor)).thenReturn(receptorSalvo);

        Receptor resultado = receptorService.salvarReceptor(receptor);

        assertEquals(receptorSalvo, resultado);
    }

    @Test
    void testDeletarReceptor() {
        Long idReceptor = 1L;

        receptorService.deletarReceptor(idReceptor);

        verify(receptorRepository, times(1)).deleteById(idReceptor);
    }
}
