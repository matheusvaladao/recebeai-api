package com.recebeai.gestaocomprasapi.api.controller;

import com.recebeai.gestaocomprasapi.api.assembler.ReceptorAssembler;
import com.recebeai.gestaocomprasapi.api.assembler.ReceptorDisassembler;
import com.recebeai.gestaocomprasapi.api.model.ReceptorModel;
import com.recebeai.gestaocomprasapi.api.model.input.ReceptorInput;
import com.recebeai.gestaocomprasapi.domain.model.Receptor;
import com.recebeai.gestaocomprasapi.domain.service.ReceptorService;
import com.recebeai.gestaocomprasapi.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receptores")
public class ReceptorController {

    private final ReceptorService receptorService;
    private final ReceptorAssembler receptorAssembler;
    private final ReceptorDisassembler receptorDisassembler;
    private final UsuarioService usuarioService;

    @Autowired
    public ReceptorController(ReceptorService receptorService, ReceptorAssembler receptorAssembler, ReceptorDisassembler receptorDisassembler, UsuarioService usuarioService) {
        this.receptorService = receptorService;
        this.receptorAssembler = receptorAssembler;
        this.receptorDisassembler = receptorDisassembler;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<ReceptorModel>> listarReceptores() {
        List<Receptor> receptores = receptorService.listarReceptores();
        return new ResponseEntity<>(receptorAssembler.toCollectionModel(receptores), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceptorModel> encontrarReceptorPorId(@PathVariable Long id) {
        Receptor receptor = receptorService.encontrarPorId(id).orElse(null);
        if (receptor != null) {
            return new ResponseEntity<>(receptorAssembler.toDTO(receptor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ReceptorModel> salvarReceptor(@RequestBody ReceptorInput receptorInput) {
        Receptor receptor = receptorDisassembler.toDomainObject(receptorInput);
        receptor.setUsuario(usuarioService.encontrarPorId(receptorInput.getIdusuario()).get());
        Receptor novoReceptor = receptorService.salvarReceptor(receptor);
        return new ResponseEntity<>(receptorAssembler.toDTO(novoReceptor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReceptor(@PathVariable Long id) {
        receptorService.deletarReceptor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

