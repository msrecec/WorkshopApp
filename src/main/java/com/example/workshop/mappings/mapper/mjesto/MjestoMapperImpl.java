package com.example.workshop.mappings.mapper.mjesto;

import com.example.workshop.mappings.mapper.zupanija.ZupanijaMapper;
import com.example.workshop.mappings.mapper.zupanija.ZupanijaMapperImpl;
import com.example.workshop.model.mjesto.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class MjestoMapperImpl implements MjestoMapper{

    private ZupanijaMapper zupanijaMapper;

    @Autowired
    public MjestoMapperImpl(ZupanijaMapperImpl zupanijaMapper) {
        this.zupanijaMapper = zupanijaMapper;
    }

    @Override
    public MjestoDTO mjestoToMjestoDTO(Mjesto mjesto) {
        return new MjestoDTO(mjesto.getPbrMjesto(), mjesto.getNazivMjesto(), zupanijaMapper.zupanijaToZupanijaDTO(mjesto.getZupanija()));
    }

    @Override
    public MjestoDTOPaginated mjestoToMjestoDTOPaginated(MjestoPaginated mjestoPaginated) {
        return new MjestoDTOPaginated(mjestoPaginated.getMjesta().stream().map(this::mjestoToMjestoDTO).collect(Collectors.toList()), mjestoPaginated.getPage());
    }

    @Override
    public Mjesto mapCommandToMjesto(MjestoCommand command) {
        return new Mjesto(command.getPbrMjesto(), command.getNazivMjesto(), zupanijaMapper.mapCommandToZupanija(command.getZupanijaCommand()));
    }
}
