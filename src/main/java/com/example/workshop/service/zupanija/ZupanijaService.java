package com.example.workshop.service.zupanija;

import com.example.workshop.model.count.Count;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.model.zupanija.ZupanijaDTOPaginated;

import java.util.List;
import java.util.Optional;

public interface ZupanijaService {
    List<ZupanijaDTO> findAll();
    Optional<ZupanijaDTO> findByNazivZupanija(String naziv);
    Optional<ZupanijaDTOPaginated> findZupanijaByPage(int page);
    Optional<Count> findZupanijaCount();
}
