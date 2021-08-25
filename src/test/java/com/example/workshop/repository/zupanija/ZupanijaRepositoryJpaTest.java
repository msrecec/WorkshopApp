package com.example.workshop.repository.zupanija;

import com.example.workshop.WorkshopApplication;
import com.example.workshop.model.zupanija.Zupanija;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties"
)
class ZupanijaRepositoryJpaTest {

    @Autowired
    ZupanijaRepositoryJpa zupanijaRepositoryJpa;

    @Test
    void findAll() {
    }

    @Test
    void findByNazivZupanija() {
        Optional<Zupanija> zupanijaTrue = zupanijaRepositoryJpa.findByNazivZupanija("Test zupanija");
        Optional<Zupanija> zupanijaFake = zupanijaRepositoryJpa.findByNazivZupanija("Test zupanija11");

        System.out.println(zupanijaTrue.isPresent());
        System.out.println(zupanijaFake.isPresent());

//        assertAll("Should return zupanija by naziv",
//            () -> {
//                assertTrue(zupanijaRepositoryJpa.findByNazivZupanija("Test zupanija11").isEmpty());
//            },
//            () -> {
//                assertTrue(zupanijaRepositoryJpa.findByNazivZupanija("Test zupanija").get().getNazivZupanija().compareTo("Test zupanija") == 0);
//            }
//        );
    }

    @Test
    void findBySifZupanija() {
    }

    @Test
    void save() {
    }
}