package com.example.workshop.rest;

import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.service.ZupanijaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zupanija")
@CrossOrigin(origins = "http://localhost:4200")
public class ZupanijaController {

    private ZupanijaService zupanijaService;

    public ZupanijaController(ZupanijaService zupanijaService) {
        this.zupanijaService = zupanijaService;
    }

    @GetMapping
    public List<ZupanijaDTO> getZupanija() {
        return zupanijaService.findAll();
    }

}
