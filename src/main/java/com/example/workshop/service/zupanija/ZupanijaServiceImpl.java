package com.example.workshop.service.zupanija;

import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.repository.zupanija.ZupanijaRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZupanijaServiceImpl implements ZupanijaService {

    private final ZupanijaRepositoryJpa zupanijaRepositoryJpa;

    public ZupanijaServiceImpl(ZupanijaRepositoryJpa zupanijaRepositoryJpa) {
        this.zupanijaRepositoryJpa = zupanijaRepositoryJpa;
    }

    @Override
    public List<ZupanijaDTO> findAll() {
        return zupanijaRepositoryJpa.findAll().stream().map(this::mapZupanijaToDTO).collect(Collectors.toList());
    }

    private ZupanijaDTO mapZupanijaToDTO(Zupanija zupanija) {
        return new ZupanijaDTO(zupanija.getSifZupanija(),zupanija.getNazivZupanija());
    }
}
