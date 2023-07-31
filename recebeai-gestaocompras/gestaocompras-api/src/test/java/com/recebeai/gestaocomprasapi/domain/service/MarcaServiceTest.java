package com.recebeai.gestaocomprasapi.domain.service;

import com.recebeai.gestaocomprasapi.domain.model.Marca;
import com.recebeai.gestaocomprasapi.domain.repository.MarcaRepository;
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

class MarcaServiceTest {

    @Mock
    private MarcaRepository marcaRepository;

    @InjectMocks
    private MarcaService marcaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarMarcas() {
        List<Marca> marcas = new ArrayList<>();
        marcas.add(new Marca(1L, "Marca 1"));
        marcas.add(new Marca(2L, "Marca 2"));

        when(marcaRepository.findAll()).thenReturn(marcas);

        List<Marca> resultado = marcaService.listarMarcas();

        assertEquals(2, resultado.size());
    }

    @Test
    void testEncontrarPorId() {
        Marca marca = new Marca(1L, "Marca 1");

        when(marcaRepository.findById(1L)).thenReturn(Optional.of(marca));

        Optional<Marca> resultado = marcaService.encontrarPorId(1L);

        assertEquals(marca, resultado.get());
    }

    @Test
    void testSalvarMarca() {
        Marca marca = new Marca(null, "Nova Marca");
        Marca marcaSalva = new Marca(1L, "Nova Marca");

        when(marcaRepository.save(marca)).thenReturn(marcaSalva);

        Marca resultado = marcaService.salvarMarca(marca);

        assertEquals(marcaSalva, resultado);
    }

    @Test
    void testDeletarMarca() {
        Long idMarca = 1L;

        marcaService.deletarMarca(idMarca);

        verify(marcaRepository, times(1)).deleteById(idMarca);
    }
}
