package com.example.workshop.service.mjesto;

import com.example.workshop.mappings.mapper.mjesto.MjestoMapper;
import com.example.workshop.mappings.mapper.mjesto.MjestoMapperImpl;
import com.example.workshop.model.count.Count;
import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.model.mjesto.MjestoDTOPaginated;
import com.example.workshop.repository.mjesto.MjestoRepository;
import com.example.workshop.repository.mjesto.MjestoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MjestoServiceImpl implements MjestoService{

    private final MjestoRepositoryJpa mjestoRepositoryJpa;
    private final MjestoRepository mjestoRepository;
    private final MjestoMapper mapper;

    @Autowired
    public MjestoServiceImpl(MjestoRepositoryJpa mjestoRepositoryJpa, MjestoMapperImpl mapper, MjestoRepository mjestoRepository) {
        this.mjestoRepositoryJpa = mjestoRepositoryJpa;
        this.mjestoRepository = mjestoRepository;
        this.mapper = mapper;
    }

    @Override
    public List<MjestoDTO> findAll() {
        return mjestoRepositoryJpa.findAll().stream().map(mapper::mjestoToMjestoDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<MjestoDTO> findByNazivMjesta(String naziv) {
        return mjestoRepositoryJpa.findByNazivMjesto(naziv).map(mapper::mjestoToMjestoDTO);
    }

    @Override
    public Optional<MjestoDTOPaginated> findMjestoByPage(int page) {
        return mjestoRepository.findMjestoByPage(page).map(mapper::mjestoToMjestoDTOPaginated);
    }

    @Override
    public Optional<Count> findMjestoCount() {
        return mjestoRepository.findMjestoCount();
    }

    @Override
    public Optional<Mjesto> testGetMjesto() {
        return mjestoRepositoryJpa.findByNazivMjesto("Križevci");
    }
}
