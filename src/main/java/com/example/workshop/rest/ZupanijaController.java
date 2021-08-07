package com.example.workshop.rest;

import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.service.zupanija.ZupanijaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
