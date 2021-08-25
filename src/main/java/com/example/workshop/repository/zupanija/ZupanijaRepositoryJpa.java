package com.example.workshop.repository.zupanija;

import com.example.workshop.model.zupanija.Zupanija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ZupanijaRepositoryJpa extends JpaRepository<Zupanija, Long> {
    List<Zupanija> findAll();
    Optional<Zupanija> findByNazivZupanija(String naziv);
    Optional<Zupanija> findBySifZupanija(Long sifZupanija);
    Zupanija save(Zupanija zupanija);
}
