package com.recebeai.gestaocomprasapi.api.controller;

import com.recebeai.gestaocomprasapi.api.assembler.MarcaAssembler;
import com.recebeai.gestaocomprasapi.api.assembler.MarcaDisassembler;
import com.recebeai.gestaocomprasapi.api.model.MarcaModel;
import com.recebeai.gestaocomprasapi.api.model.input.MarcaInput;
import com.recebeai.gestaocomprasapi.domain.model.Marca;
import com.recebeai.gestaocomprasapi.domain.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;
    private final MarcaAssembler marcaAssembler;
    private final MarcaDisassembler marcaDisassembler;

    @Autowired
    public MarcaController(MarcaService marcaService, MarcaAssembler marcaAssembler, MarcaDisassembler marcaDisassembler) {
        this.marcaService = marcaService;
        this.marcaAssembler = marcaAssembler;
        this.marcaDisassembler = marcaDisassembler;
    }

    @GetMapping
    public ResponseEntity<List<MarcaModel>> listarMarcas() {
        List<MarcaModel> marcasDTO = marcaAssembler.toCollectionModel(marcaService.listarMarcas());
        return new ResponseEntity<>(marcasDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaModel> encontrarMarcaPorId(@PathVariable Long id) {
        Marca marca = marcaService.encontrarPorId(id).orElse(null);
        MarcaModel marcaModel = marcaAssembler.toDTO(marca);
        if (marca != null) {
            return new ResponseEntity<>(marcaModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<MarcaModel> salvarMarca(@RequestBody MarcaInput marcaInput) {
        Marca novaMarca = marcaService.salvarMarca(marcaDisassembler.toDomainObject(marcaInput));
        return new ResponseEntity<>(marcaAssembler.toDTO(novaMarca), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMarca(@PathVariable Long id) {
        marcaService.deletarMarca(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
