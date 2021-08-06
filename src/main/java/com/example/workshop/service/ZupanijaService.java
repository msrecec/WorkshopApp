package com.example.workshop.service;

import com.example.workshop.model.zupanija.ZupanijaDTO;

import java.util.List;

public interface ZupanijaService {
    List<ZupanijaDTO> findAll();
}
