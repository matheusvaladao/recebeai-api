package com.recebeai.gestaoentregasapi.api.controller;

import com.recebeai.gestaoentregasapi.api.assembler.CategoriaAssembler;
import com.recebeai.gestaoentregasapi.api.assembler.CategoriaDisassembler;
import com.recebeai.gestaoentregasapi.api.model.CategoriaModel;
import com.recebeai.gestaoentregasapi.api.model.input.CategoriaInput;
import com.recebeai.gestaoentregasapi.domain.model.Categoria;
import com.recebeai.gestaoentregasapi.domain.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaAssembler categoriaAssembler;
    private final CategoriaDisassembler categoriaDisassembler;

    @Autowired
    public CategoriaController(CategoriaService categoriaService, CategoriaAssembler categoriaAssembler, CategoriaDisassembler categoriaDisassembler) {
        this.categoriaService = categoriaService;
        this.categoriaAssembler = categoriaAssembler;
        this.categoriaDisassembler = categoriaDisassembler;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> listarCategorias() {
        List<Categoria> categorias = categoriaService.listarCategorias();
        return new ResponseEntity<>(categoriaAssembler.toCollectionModel(categorias), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> encontrarCategoriaPorId(@PathVariable Long id) {
        Categoria categoria = categoriaService.encontrarPorId(id).orElse(null);
        if (categoria != null) {
            return new ResponseEntity<>(categoriaAssembler.toDTO(categoria), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> salvarCategoria(@RequestBody CategoriaInput categoriaInput) {
        Categoria categoria = categoriaDisassembler.toDomainObject(categoriaInput);
        Categoria novaCategoria = categoriaService.salvarCategoria(categoria);
        return new ResponseEntity<>(categoriaAssembler.toDTO(novaCategoria), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
