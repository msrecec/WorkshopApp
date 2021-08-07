package com.example.workshop.repository.mjesto;

import com.example.workshop.model.count.Count;
import com.example.workshop.model.mjesto.MjestoPaginated;
import com.example.workshop.model.zupanija.ZupanijaPaginated;

import java.util.Optional;

public interface MjestoRepository {
    Optional<MjestoPaginated> findMjestoByPage(int page);
    Optional<Count> findMjestoCount();
}
