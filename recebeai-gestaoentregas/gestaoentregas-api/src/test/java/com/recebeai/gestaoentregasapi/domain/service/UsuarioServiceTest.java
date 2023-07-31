package com.recebeai.gestaoentregasapi.domain.service;

import com.recebeai.gestaoentregasapi.domain.model.Usuario;
import com.recebeai.gestaoentregasapi.domain.repository.UsuarioRepository;
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

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "usuario1@example.com", "senha123", "Usuario 1", "12345678901", "12345678", "Rua A", new BigDecimal(10.12345678), new BigDecimal(-20.12345678)));
        usuarios.add(new Usuario(2L, "usuario2@example.com", "senha456", "Usuario 2", "98765432100", "87654321", "Rua B", new BigDecimal(30.12345678), new BigDecimal(-40.12345678)));

        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> resultado = usuarioService.listarUsuarios();

        assertEquals(2, resultado.size());
    }

    @Test
    void testEncontrarPorId() {
        Usuario usuario = new Usuario(1L, "usuario1@example.com", "senha123", "Usuario 1", "12345678901", "12345678", "Rua A", new BigDecimal(10.12345678), new BigDecimal(-20.12345678));

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.encontrarPorId(1L);

        assertEquals(usuario, resultado.get());
    }

    @Test
    void testSalvarUsuario() {
        Usuario usuario = new Usuario(null, "usuario3@example.com", "senha789", "Usuario 3", "98765432101", "87654321", "Rua C", new BigDecimal(50.12345678), new BigDecimal(-60.12345678));
        Usuario usuarioSalvo = new Usuario(3L, "usuario3@example.com", "senha789", "Usuario 3", "98765432101", "87654321", "Rua C", new BigDecimal(50.12345678), new BigDecimal(-60.12345678));

        when(usuarioRepository.save(usuario)).thenReturn(usuarioSalvo);

        Usuario resultado = usuarioService.salvarUsuario(usuario);

        assertEquals(usuarioSalvo, resultado);
    }

    @Test
    void testDeletarUsuario() {
        Long idUsuario = 1L;

        usuarioService.deletarUsuario(idUsuario);

        verify(usuarioRepository, times(1)).deleteById(idUsuario);
    }
}
