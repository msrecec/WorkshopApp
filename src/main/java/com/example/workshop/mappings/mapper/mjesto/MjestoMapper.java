package com.example.workshop.mappings.mapper.mjesto;

import com.example.workshop.model.mjesto.*;

public interface MjestoMapper {
    MjestoDTO mjestoToMjestoDTO(Mjesto mjesto);
    MjestoDTOPaginated mjestoToMjestoDTOPaginated(MjestoPaginated mjestoPaginated);
    Mjesto mapCommandToMjesto(MjestoCommand command);
}
