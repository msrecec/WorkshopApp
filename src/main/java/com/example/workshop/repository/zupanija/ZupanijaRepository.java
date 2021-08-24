package com.example.workshop.repository.zupanija;

import com.example.workshop.model.count.Count;
import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaPaginated;

import java.util.List;
import java.util.Optional;

public interface ZupanijaRepository {
    Optional<ZupanijaPaginated> findZupanijaByPage(int page);
    Optional<Count> findZupanijaCount();
    Optional<Zupanija> save(Zupanija zupanija);
    Optional<Zupanija> update(Zupanija zupanija);
}
