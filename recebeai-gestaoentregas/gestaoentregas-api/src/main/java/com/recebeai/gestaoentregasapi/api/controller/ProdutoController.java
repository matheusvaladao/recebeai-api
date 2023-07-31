package com.recebeai.gestaoentregasapi.api.controller;

import com.recebeai.gestaoentregasapi.api.assembler.ProdutoAssembler;
import com.recebeai.gestaoentregasapi.api.assembler.ProdutoDisassembler;
import com.recebeai.gestaoentregasapi.api.model.ProdutoModel;
import com.recebeai.gestaoentregasapi.api.model.input.ProdutoInput;
import com.recebeai.gestaoentregasapi.domain.model.Produto;
import com.recebeai.gestaoentregasapi.domain.service.CategoriaService;
import com.recebeai.gestaoentregasapi.domain.service.MarcaService;
import com.recebeai.gestaoentregasapi.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoAssembler produtoAssembler;
    private final ProdutoDisassembler produtoDisassembler;
    private final MarcaService marcaService;
    private final CategoriaService categoriaService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, ProdutoAssembler produtoAssembler, ProdutoDisassembler produtoDisassembler, MarcaService marcaService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.produtoAssembler = produtoAssembler;
        this.produtoDisassembler = produtoDisassembler;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return new ResponseEntity<>(produtoAssembler.toCollectionModel(produtos), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> encontrarProdutoPorId(@PathVariable Long id) {
        Produto produto = produtoService.encontrarPorId(id).orElse(null);
        if (produto != null) {
            return new ResponseEntity<>(produtoAssembler.toDTO(produto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> salvarProduto(@RequestBody ProdutoInput produtoInput) {
        Produto produto = produtoDisassembler.toDomainObject(produtoInput);
        produto.setMarca(marcaService.encontrarPorId(produtoInput.getIdmarca()).get());
        produto.setCategoria(categoriaService.encontrarPorId(produtoInput.getIdcategoria()).get());
        Produto novoProduto = produtoService.salvarProduto(produto);
        return new ResponseEntity<>(produtoAssembler.toDTO(novoProduto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
