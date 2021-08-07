package com.example.workshop.repository.zupanija;

import com.example.workshop.model.zupanija.Zupanija;

import java.util.List;

public interface ZupanijaRepository {
    public List<Zupanija> findZupanijaByPage(int page);
}
