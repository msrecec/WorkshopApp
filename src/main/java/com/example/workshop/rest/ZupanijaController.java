package com.example.workshop.rest;

import com.example.workshop.model.count.Count;
import com.example.workshop.model.zupanija.ZupanijaCommand;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.model.zupanija.ZupanijaDTOPaginated;
import com.example.workshop.service.zupanija.ZupanijaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/zupanija")
@CrossOrigin(origins = "http://localhost:4200")
public class ZupanijaController {

    private ZupanijaService zupanijaService;

    public ZupanijaController(ZupanijaService zupanijaService) {
        this.zupanijaService = zupanijaService;
    }

    @GetMapping
    public List<ZupanijaDTO> getAllZupanije() {
        return zupanijaService.findAll();
    }

    @GetMapping("/{nazivZupanija}")
    public ResponseEntity<ZupanijaDTO> getZupanijaByNaziv(@PathVariable final String nazivZupanija) {
        return zupanijaService.findByNazivZupanija(nazivZupanija)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @GetMapping(params = "page")
    public ResponseEntity<ZupanijaDTOPaginated> getZupanijaPaginated(@RequestParam(name = "page") final int page) {
        return zupanijaService.findZupanijaByPage(page)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound()
                        .build()
                );
    }

    @GetMapping("/count")
    public ResponseEntity<Count> getZupanijaCount() {
        return zupanijaService.findZupanijaCount()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ZupanijaDTO> save(@Valid @RequestBody final ZupanijaCommand command) {
        return zupanijaService.save(command)
                .map(
                        zupanijaDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(zupanijaDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @PutMapping
    public ResponseEntity<ZupanijaDTO> update(@Valid @RequestBody final ZupanijaCommand command) {
        return zupanijaService.update(command)
                .map(
                        zupanijaDTO -> ResponseEntity
                                .status(HttpStatus.OK)
                                .body(zupanijaDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

}
