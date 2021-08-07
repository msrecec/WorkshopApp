package com.example.workshop.service.zupanija;

import com.example.workshop.model.zupanija.ZupanijaDTO;

import java.util.List;
import java.util.Optional;

public interface ZupanijaService {
    List<ZupanijaDTO> findAll();
    Optional<ZupanijaDTO> findByNazivZupanija(String naziv);
    List<ZupanijaDTO> findZupanijaByPage(int page);
}
