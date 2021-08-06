package com.example.workshop.mappings;

import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaDTO;

public interface Mapper {
    ZupanijaDTO zupanijaToZupanijaDTO(Zupanija zupanija);
    MjestoDTO mjestoToMjestoDTO(Mjesto mjesto);
}
