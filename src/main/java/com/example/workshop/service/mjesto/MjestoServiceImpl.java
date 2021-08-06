package com.example.workshop.service.mjesto;

import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.repository.mjesto.MjestoRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MjestoServiceImpl implements MjestoService{

    private final MjestoRepositoryJpa mjestoRepositoryJpa;

    public MjestoServiceImpl(MjestoRepositoryJpa mjestoRepositoryJpa) {
        this.mjestoRepositoryJpa = mjestoRepositoryJpa;
    }

    @Override
    public List<MjestoDTO> findAll() {
        return mjestoRepositoryJpa.findAll().stream().map(this::mapMjestoToDTO).collect(Collectors.toList());
    }

    private MjestoDTO mapMjestoToDTO(Mjesto mjesto) {
        return new MjestoDTO(mjesto.getPbrMjesto(), mjesto.getNazivMjesto(), mjesto.getSifZupanija());
    }
}
