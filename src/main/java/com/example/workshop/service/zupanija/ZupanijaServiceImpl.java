package com.example.workshop.service.zupanija;

import com.example.workshop.mappings.Mapper;
import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.repository.zupanija.ZupanijaRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZupanijaServiceImpl implements ZupanijaService {

    private final ZupanijaRepositoryJpa zupanijaRepositoryJpa;
    private final Mapper mapper;

    @Autowired
    public ZupanijaServiceImpl(ZupanijaRepositoryJpa zupanijaRepositoryJpa, Mapper mapper) {
        this.zupanijaRepositoryJpa = zupanijaRepositoryJpa;
        this.mapper = mapper;
    }

    @Override
    public List<ZupanijaDTO> findAll() {
        return zupanijaRepositoryJpa.findAll().stream().map(mapper::zupanijaToZupanijaDTO).collect(Collectors.toList());
    }

}
