package com.example.workshop.repository.mjesto;

import com.example.workshop.model.mjesto.Mjesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MjestoRepositoryJpa extends JpaRepository<Mjesto, Long> {
    List<Mjesto> findAll();
}
