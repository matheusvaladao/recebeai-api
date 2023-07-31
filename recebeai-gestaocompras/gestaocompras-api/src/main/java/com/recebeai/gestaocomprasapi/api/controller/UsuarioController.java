package com.recebeai.gestaocomprasapi.api.controller;

import com.recebeai.gestaocomprasapi.api.assembler.UsuarioAssembler;
import com.recebeai.gestaocomprasapi.api.assembler.UsuarioDisassembler;
import com.recebeai.gestaocomprasapi.api.model.UsuarioModel;
import com.recebeai.gestaocomprasapi.api.model.input.UsuarioInput;
import com.recebeai.gestaocomprasapi.domain.model.Usuario;
import com.recebeai.gestaocomprasapi.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioAssembler usuarioAssembler;
    private final UsuarioDisassembler usuarioDisassembler;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioAssembler usuarioAssembler, UsuarioDisassembler usuarioDisassembler) {
        this.usuarioService = usuarioService;
        this.usuarioAssembler = usuarioAssembler;
        this.usuarioDisassembler = usuarioDisassembler;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return new ResponseEntity<>(usuarioAssembler.toCollectionModel(usuarios), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> encontrarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.encontrarPorId(id).orElse(null);
        if (usuario != null) {
            return new ResponseEntity<>(usuarioAssembler.toDTO(usuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody UsuarioInput usuarioInput) {
        Usuario usuario = usuarioDisassembler.toDomainObject(usuarioInput);
        Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
        return new ResponseEntity<>(usuarioAssembler.toDTO(novoUsuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
