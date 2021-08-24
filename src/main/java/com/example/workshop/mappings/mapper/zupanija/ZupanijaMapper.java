package com.example.workshop.mappings.mapper.zupanija;

import com.example.workshop.model.zupanija.*;

public interface ZupanijaMapper {
    ZupanijaDTO zupanijaToZupanijaDTO(Zupanija zupanija);
    ZupanijaDTOPaginated zupanijaToZupanijaDTOPaginated(ZupanijaPaginated zupanijaPaginated);
    Zupanija mapCommandToZupanija(ZupanijaCommand command);
}
