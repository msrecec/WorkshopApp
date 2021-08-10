package com.example.workshop.mappings.mapper.mjesto;

import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.model.mjesto.MjestoDTOPaginated;
import com.example.workshop.model.mjesto.MjestoPaginated;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
@NoArgsConstructor
public class MjestoMapperImpl implements MjestoMapper{

    @Override
    public MjestoDTO mjestoToMjestoDTO(Mjesto mjesto) {
        return new MjestoDTO(mjesto.getPbrMjesto(), mjesto.getNazivMjesto());
    }

    @Override
    public MjestoDTOPaginated mjestoToMjestoDTOPaginated(MjestoPaginated mjestoPaginated) {
        return new MjestoDTOPaginated(mjestoPaginated.getMjesta().stream().map(this::mjestoToMjestoDTO).collect(Collectors.toList()), mjestoPaginated.getPage());
    }
}
