package com.example.workshop.service.mjesto;

import com.example.workshop.mappings.mapper.Mapper;
import com.example.workshop.model.mjesto.MjestoDTO;
import com.example.workshop.repository.mjesto.MjestoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MjestoServiceImpl implements MjestoService{

    private final MjestoRepositoryJpa mjestoRepositoryJpa;
    private final Mapper mapper;

    @Autowired
    public MjestoServiceImpl(MjestoRepositoryJpa mjestoRepositoryJpa, Mapper mapper) {
        this.mjestoRepositoryJpa = mjestoRepositoryJpa;
        this.mapper = mapper;
    }

    @Override
    public List<MjestoDTO> findAll() {
        return mjestoRepositoryJpa.findAll().stream().map(mapper::mjestoToMjestoDTO).collect(Collectors.toList());
    }

}
