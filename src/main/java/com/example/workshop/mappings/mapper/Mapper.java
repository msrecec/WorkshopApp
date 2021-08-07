package com.example.workshop.mappings.mapper;

import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.model.mjesto.MjestoDTOPaginated;
import com.example.workshop.model.mjesto.MjestoPaginated;
import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.model.zupanija.ZupanijaDTOPaginated;
import com.example.workshop.model.zupanija.ZupanijaPaginated;

public interface Mapper {
    ZupanijaDTO zupanijaToZupanijaDTO(Zupanija zupanija);
    ZupanijaDTOPaginated zupanijaToZupanijaDTOPaginated(ZupanijaPaginated zupanijaPaginated);
    MjestoDTO mjestoToMjestoDTO(Mjesto mjesto);
    MjestoDTOPaginated mjestoToMjestoDTOPaginated(MjestoPaginated mjestoPaginated);
}
