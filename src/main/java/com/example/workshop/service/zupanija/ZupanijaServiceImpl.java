package com.example.workshop.service.zupanija;

import com.example.workshop.mappings.mapper.Mapper;
import com.example.workshop.model.count.Count;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.model.zupanija.ZupanijaDTOPaginated;
import com.example.workshop.repository.zupanija.ZupanijaRepository;
import com.example.workshop.repository.zupanija.ZupanijaRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZupanijaServiceImpl implements ZupanijaService {

    private final ZupanijaRepositoryJpa zupanijaRepositoryJpa;
    private final ZupanijaRepository zupanijaRepository;
    private final Mapper mapper;

    @Autowired
    public ZupanijaServiceImpl(ZupanijaRepositoryJpa zupanijaRepositoryJpa, Mapper mapper, ZupanijaRepository zupanijaRepository) {
        this.zupanijaRepositoryJpa = zupanijaRepositoryJpa;
        this.zupanijaRepository = zupanijaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ZupanijaDTO> findAll() {
        return zupanijaRepositoryJpa.findAll().stream().map(mapper::zupanijaToZupanijaDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<ZupanijaDTO> findByNazivZupanija(String naziv) {
        return zupanijaRepositoryJpa.findByNazivZupanija(naziv).map(mapper::zupanijaToZupanijaDTO);
    }

    @Override
    public Optional<ZupanijaDTOPaginated> findZupanijaByPage(int page) {
        return zupanijaRepository.findZupanijaByPage(page).map(mapper::zupanijaToZupanijaDTOPaginated);
    }

    @Override
    public Optional<Count> findZupanijaCount() {
        return zupanijaRepository.findZupanijaCount();
    }
}
