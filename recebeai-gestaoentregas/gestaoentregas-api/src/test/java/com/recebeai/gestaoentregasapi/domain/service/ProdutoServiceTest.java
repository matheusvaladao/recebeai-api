package com.recebeai.gestaoentregasapi.domain.service;

import com.recebeai.gestaoentregasapi.domain.model.Produto;
import com.recebeai.gestaoentregasapi.domain.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1L, "Produto 1", new BigDecimal("100.00")));
        produtos.add(new Produto(2L, "Produto 2", new BigDecimal("200.00")));

        when(produtoRepository.findAll()).thenReturn(produtos);

        List<Produto> resultado = produtoService.listarProdutos();

        assertEquals(2, resultado.size());
    }

    @Test
    void testEncontrarPorId() {
        Produto produto = new Produto(1L, "Produto 1", new BigDecimal("100.00"));

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Optional<Produto> resultado = produtoService.encontrarPorId(1L);

        assertEquals(produto, resultado.get());
    }

    @Test
    void testSalvarProduto() {
        Produto produto = new Produto(null, "Novo Produto", new BigDecimal("300.00"));
        Produto produtoSalvo = new Produto(3L, "Novo Produto", new BigDecimal("300.00"));

        when(produtoRepository.save(produto)).thenReturn(produtoSalvo);

        Produto resultado = produtoService.salvarProduto(produto);

        assertEquals(produtoSalvo, resultado);
    }

    @Test
    void testDeletarProduto() {
        Long idProduto = 1L;

        produtoService.deletarProduto(idProduto);

        verify(produtoRepository, times(1)).deleteById(idProduto);
    }
}
