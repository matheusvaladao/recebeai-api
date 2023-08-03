package com.recebeai.gestaoentregasapi.domain.service;

import com.recebeai.gestaoentregasapi.domain.model.Categoria;
import com.recebeai.gestaoentregasapi.domain.repository.CategoriaRepository;
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

class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(1L, "Categoria 1"));
        categorias.add(new Categoria(2L, "Categoria 2"));

        when(categoriaRepository.findAll()).thenReturn(categorias);

        List<Categoria> resultado = categoriaService.listarCategorias();

        assertEquals(2, resultado.size());
    }

    @Test
    void testEncontrarPorId() {
        Categoria categoria = new Categoria(1L, "Categoria 1");

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));

        Optional<Categoria> resultado = categoriaService.encontrarPorId(1L);

        assertEquals(categoria, resultado.get());
    }

    @Test
    void testSalvarCategoria() {
        Categoria categoria = new Categoria(1L, "Nova Categoria");

        when(categoriaRepository.save(categoria)).thenReturn(categoria);

        Categoria resultado = categoriaService.salvarCategoria(categoria);

        assertEquals(categoria, resultado);
    }

    @Test
    void testDeletarCategoria() {
        Long idCategoria = 1L;

        categoriaService.deletarCategoria(idCategoria);

        verify(categoriaRepository, times(1)).deleteById(idCategoria);
    }
}
