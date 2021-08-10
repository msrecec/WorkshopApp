package com.example.workshop.mappings.mapper.zupanija;

import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.model.zupanija.ZupanijaDTOPaginated;
import com.example.workshop.model.zupanija.ZupanijaPaginated;

public interface ZupanijaMapper {
    ZupanijaDTO zupanijaToZupanijaDTO(Zupanija zupanija);
    ZupanijaDTOPaginated zupanijaToZupanijaDTOPaginated(ZupanijaPaginated zupanijaPaginated);
}
