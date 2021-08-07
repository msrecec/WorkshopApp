package com.example.workshop.service.mjesto;

import com.example.workshop.model.count.Count;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.model.mjesto.MjestoDTOPaginated;

import java.util.List;
import java.util.Optional;

public interface MjestoService {
    List<MjestoDTO> findAll();
    Optional<MjestoDTO> findByNazivMjesta(String naziv);
    Optional<MjestoDTOPaginated> findMjestoByPage(int page);
    Optional<Count> findMjestoCount();
}
