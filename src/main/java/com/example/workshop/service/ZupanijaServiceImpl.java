package com.example.workshop.service;

import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.repository.ZupanijaRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZupanijaServiceImpl implements ZupanijaService {

    private ZupanijaRepositoryJpa zupanijaRepositoryJpa;

    public ZupanijaServiceImpl(ZupanijaRepositoryJpa zupanijaRepositoryJpa) {
        this.zupanijaRepositoryJpa = zupanijaRepositoryJpa;
    }

    @Override
    public List<ZupanijaDTO> findAll() {
        return zupanijaRepositoryJpa.findAll().stream().map(this::mapZupanijaToDTO).collect(Collectors.toList());
    }

    private ZupanijaDTO mapZupanijaToDTO(Zupanija zupanija) {
        return new ZupanijaDTO(zupanija.getNazivZupanija());
    }
}
