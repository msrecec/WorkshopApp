package com.example.workshop.repository.zupanija;

import com.example.workshop.mappings.rowMapper.RowMapperCustom;
import com.example.workshop.model.count.Count;
import com.example.workshop.model.zupanija.Zupanija;
import com.example.workshop.model.zupanija.ZupanijaPaginated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ZupanijaRepositoryImpl implements ZupanijaRepository{

    private static final String SELECT_ALL = "SELECT * FROM zupanija ";
    private static final String SELECT_COUNT = "SELECT COUNT(*) FROM zupanija ";
    private static final int pageSize = 10;
    private final RowMapperCustom rowMapperCustom;

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;
    private final ZupanijaRepositoryJpa zupanijaRepositoryJpa;

    @Autowired
    public ZupanijaRepositoryImpl(JdbcTemplate jdbc, RowMapperCustom rowMapperCustom, ZupanijaRepositoryJpa zupanijaRepositoryJpa) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("zupanija");
        this.rowMapperCustom = rowMapperCustom;
        this.zupanijaRepositoryJpa = zupanijaRepositoryJpa;
    }

    @Override
    public Optional<Zupanija> update(Zupanija zupanija) {
        int executed = jdbc.update("UPDATE zupanija SET naziv_zupanija = ? WHERE sif_zupanija = ?",
                zupanija.getNazivZupanija(),
                zupanija.getSifZupanija()
        );
        if(executed > 0) {
            return Optional.of(zupanija);
        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<ZupanijaPaginated> findZupanijaByPage(int page) {
        try {
            if(page < 1) {
                throw new RuntimeException("Page must not be smaller than 1");
            }
            Optional<Count> count = findZupanijaCount();
            if(count.isEmpty()) {
                throw new RuntimeException("Count must not be empty");
            }

            int offset = (page-1) * pageSize;

            if(offset >= count.get().getCount()) {
                throw new RuntimeException("Offset must be smaller than the total number of elements");
            }

            List<Zupanija> zupanije = jdbc.query(SELECT_ALL + "LIMIT ? OFFSET ? ", rowMapperCustom::mapRowToZupanija, pageSize, offset);

            return Optional.ofNullable(new ZupanijaPaginated(zupanije, count.get().getCount()));

        } catch (RuntimeException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Count> findZupanijaCount() {
        try {
            return Optional.ofNullable(jdbc.queryForObject(SELECT_COUNT, rowMapperCustom::mapRowToCount));
        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public void deleteBySifZupanija(Long sifZupanija) {
        Optional<Zupanija> zupanija = zupanijaRepositoryJpa.findBySifZupanija(sifZupanija);

        if(zupanija.isPresent()) {
            jdbc.update("DELETE FROM zupanija WHERE sif_zupanija = ?", zupanija.get().getSifZupanija());
        }
    }
}
