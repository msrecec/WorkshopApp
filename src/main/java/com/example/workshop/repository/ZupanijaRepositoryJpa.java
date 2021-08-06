package com.example.workshop.repository;

import com.example.workshop.model.zupanija.Zupanija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZupanijaRepositoryJpa extends JpaRepository<Zupanija, Long> {
    List<Zupanija> findAll();
}
