package com.example.workshop.rest;


import com.example.workshop.model.count.Count;
import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.mjesto.MjestoCommand;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.model.mjesto.MjestoDTOPaginated;
import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.service.mjesto.MjestoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/mjesto")
@CrossOrigin(origins = "http://localhost:4200")
public class MjestoController {

    private final MjestoService mjestoService;

    public MjestoController(MjestoService mjestoService) {
        this.mjestoService = mjestoService;
    }

    @GetMapping
    List<MjestoDTO> getMjesta() {
        return this.mjestoService.findAll();
    }


    @GetMapping("/{nazivMjesta}")
    public ResponseEntity<MjestoDTO> getMjestoByNaziv(@PathVariable final String nazivMjesta) {
        return mjestoService.findByNazivMjesta(nazivMjesta)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @GetMapping(params = "page")
    public ResponseEntity<MjestoDTOPaginated> getMjestoPaginated(@RequestParam(name = "page") final int page) {
        return mjestoService.findMjestoByPage(page)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound()
                                .build()
                );
    }

    @GetMapping("/count")
    public ResponseEntity<Count> getMjestoCount() {
        return mjestoService.findMjestoCount()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MjestoDTO> save(@Valid @RequestBody final MjestoCommand command) {
        return mjestoService.save(command)
                .map(
                        mjestoDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(mjestoDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }


}
