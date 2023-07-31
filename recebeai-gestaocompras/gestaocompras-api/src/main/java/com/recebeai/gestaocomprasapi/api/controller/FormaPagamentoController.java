package com.recebeai.gestaocomprasapi.api.controller;

import com.recebeai.gestaocomprasapi.api.assembler.FormaPagamentoAssembler;
import com.recebeai.gestaocomprasapi.api.assembler.FormaPagamentoDisassembler;
import com.recebeai.gestaocomprasapi.api.model.FormaPagamentoModel;
import com.recebeai.gestaocomprasapi.api.model.input.FormaPagamentoInput;
import com.recebeai.gestaocomprasapi.domain.model.FormaPagamento;
import com.recebeai.gestaocomprasapi.domain.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

    private final FormaPagamentoService formaPagamentoService;
    private final FormaPagamentoAssembler formaPagamentoAssembler;
    private final FormaPagamentoDisassembler formaPagamentoDisassembler;

    @Autowired
    public FormaPagamentoController(FormaPagamentoService formaPagamentoService, FormaPagamentoAssembler formaPagamentoAssembler, FormaPagamentoDisassembler formaPagamentoDisassembler) {
        this.formaPagamentoService = formaPagamentoService;
        this.formaPagamentoAssembler = formaPagamentoAssembler;
        this.formaPagamentoDisassembler = formaPagamentoDisassembler;
    }

    @GetMapping
    public ResponseEntity<List<FormaPagamentoModel>> listarFormasPagamento() {
        List<FormaPagamento> formasPagamento = formaPagamentoService.listarFormasPagamento();
        return new ResponseEntity<>(formaPagamentoAssembler.toCollectionModel(formasPagamento), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamentoModel> encontrarFormaPagamentoPorId(@PathVariable Long id) {
        FormaPagamento formaPagamento = formaPagamentoService.encontrarPorId(id).orElse(null);
        if (formaPagamento != null) {
            return new ResponseEntity<>(formaPagamentoAssembler.toDTO(formaPagamento), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<FormaPagamentoModel> salvarFormaPagamento(@RequestBody FormaPagamentoInput formaPagamentoInput) {
        FormaPagamento formaPagamento = formaPagamentoDisassembler.toDomainObject(formaPagamentoInput);
        FormaPagamento novaFormaPagamento = formaPagamentoService.salvarFormaPagamento(formaPagamento);
        return new ResponseEntity<>(formaPagamentoAssembler.toDTO(novaFormaPagamento), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFormaPagamento(@PathVariable Long id) {
        formaPagamentoService.deletarFormaPagamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
