package com.example.workshop.rest;


import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.service.mjesto.MjestoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mjesto")
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
}
