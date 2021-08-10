package com.example.workshop.mappings.mapper.zupanija;

import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.model.zupanija.ZupanijaDTOPaginated;
import com.example.workshop.model.zupanija.ZupanijaPaginated;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
@NoArgsConstructor
public class ZupanijaMapperImpl implements ZupanijaMapper{
    @Override
    public ZupanijaDTO zupanijaToZupanijaDTO(Zupanija zupanija) {
        return new ZupanijaDTO( zupanija.getNazivZupanija());
    }

    @Override
    public ZupanijaDTOPaginated zupanijaToZupanijaDTOPaginated(ZupanijaPaginated zupanijaPaginated) {
        return new ZupanijaDTOPaginated(zupanijaPaginated.getZupanije().stream().map(this::zupanijaToZupanijaDTO).collect(Collectors.toList()), zupanijaPaginated.getPage());
    }
}
