package com.example.workshop.mappings;

import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MapperImpl implements Mapper {
    @Override
    public ZupanijaDTO zupanijaToZupanijaDTO(Zupanija zupanija) {
        return new ZupanijaDTO(zupanija.getSifZupanija(), zupanija.getNazivZupanija());
    }

    @Override
    public MjestoDTO mjestoToMjestoDTO(Mjesto mjesto) {
        return new MjestoDTO(mjesto.getPbrMjesto(), mjesto.getNazivMjesto());
    }
}
