package com.recebeai.gestaoentregasapi.api.controller;

import com.recebeai.gestaoentregasapi.api.assembler.EntregaAssembler;
import com.recebeai.gestaoentregasapi.api.assembler.EntregaDisassembler;
import com.recebeai.gestaoentregasapi.api.model.EntregaModel;
import com.recebeai.gestaoentregasapi.api.model.input.EntregaInput;
import com.recebeai.gestaoentregasapi.domain.model.Entrega;
import com.recebeai.gestaoentregasapi.domain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService entregaService;
    private final EntregaAssembler entregaAssembler;
    private final EntregaDisassembler entregaDisassembler;
    private final ReceptorService receptorService;
    private final UsuarioService usuarioService;
    private final ProdutoService produtoService;
    private final FormaPagamentoService formaPagamentoService;

    @Autowired
    public EntregaController(EntregaService entregaService, EntregaAssembler entregaAssembler, EntregaDisassembler entregaDisassembler, ReceptorService receptorService, UsuarioService usuarioService, ProdutoService produtoService, FormaPagamentoService formaPagamentoService) {
        this.entregaService = entregaService;
        this.entregaAssembler = entregaAssembler;
        this.entregaDisassembler = entregaDisassembler;
        this.receptorService = receptorService;
        this.usuarioService = usuarioService;
        this.produtoService = produtoService;
        this.formaPagamentoService = formaPagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<EntregaModel>> listarEntregas() {
        List<Entrega> entregas = entregaService.listarEntregas();
        return new ResponseEntity<>(entregaAssembler.toCollectionModel(entregas), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaModel> encontrarEntregaPorId(@PathVariable Long id) {
        Entrega entrega = entregaService.encontrarPorId(id).orElse(null);
        if (entrega != null) {
            return new ResponseEntity<>(entregaAssembler.toDTO(entrega), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EntregaModel> salvarEntrega(@RequestBody EntregaInput entregaInput) {
        Entrega entrega = entregaDisassembler.toDomainObject(entregaInput);
        entrega.setReceptor(receptorService.encontrarPorId(entregaInput.getIdreceptor()).get());
        entrega.setUsuario(usuarioService.encontrarPorId(entregaInput.getIdusuario()).get());
        entrega.setProduto(produtoService.encontrarPorId(entregaInput.getIdproduto()).get());
        entrega.setFormaPagamento(formaPagamentoService.encontrarPorId(entregaInput.getIdFormaPagamento()).get());
        Entrega novaEntrega = entregaService.salvarEntrega(entrega);
        return new ResponseEntity<>(entregaAssembler.toDTO(novaEntrega), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntrega(@PathVariable Long id) {
        entregaService.deletarEntrega(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
