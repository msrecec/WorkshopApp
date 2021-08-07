package com.example.workshop.mappings.mapper;

import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.model.mjesto.MjestoDTOPaginated;
import com.example.workshop.model.mjesto.MjestoPaginated;
import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaDTO;
import com.example.workshop.model.zupanija.ZupanijaDTOPaginated;
import com.example.workshop.model.zupanija.ZupanijaPaginated;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class MapperImpl implements Mapper {
    @Override
    public ZupanijaDTO zupanijaToZupanijaDTO(Zupanija zupanija) {
        return new ZupanijaDTO( zupanija.getNazivZupanija());
    }

    @Override
    public MjestoDTO mjestoToMjestoDTO(Mjesto mjesto) {
        return new MjestoDTO(mjesto.getPbrMjesto(), mjesto.getNazivMjesto());
    }

    @Override
    public ZupanijaDTOPaginated zupanijaToZupanijaDTOPaginated(ZupanijaPaginated zupanijaPaginated) {
        return new ZupanijaDTOPaginated(zupanijaPaginated.getZupanije().stream().map(this::zupanijaToZupanijaDTO).collect(Collectors.toList()), zupanijaPaginated.getPage());
    }

    @Override
    public MjestoDTOPaginated mjestoToMjestoDTOPaginated(MjestoPaginated mjestoPaginated) {
        return new MjestoDTOPaginated(mjestoPaginated.getMjesta().stream().map(this::mjestoToMjestoDTO).collect(Collectors.toList()), mjestoPaginated.getPage());
    }
}
