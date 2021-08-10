package com.example.workshop.mappings.mapper.mjesto;

import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.model.mjesto.MjestoDTOPaginated;
import com.example.workshop.model.mjesto.MjestoPaginated;

public interface MjestoMapper {
    MjestoDTO mjestoToMjestoDTO(Mjesto mjesto);
    MjestoDTOPaginated mjestoToMjestoDTOPaginated(MjestoPaginated mjestoPaginated);
}
