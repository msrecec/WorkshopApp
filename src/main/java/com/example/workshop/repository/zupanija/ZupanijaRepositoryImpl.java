package com.example.workshop.repository.zupanija;

import com.example.workshop.mappings.rowMapper.RowMapperCustom;
import com.example.workshop.model.zupanija.Zupanija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ZupanijaRepositoryImpl implements ZupanijaRepository{

    private static final String SELECT_ALL = "SELECT * FROM zupanija ";
    private static final String SELECT_COUNT = "SELECT COUNT(*) FROM zupanija ";
    private static final int pageSize = 10;
    private final RowMapperCustom rowMapperCustom;

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    @Autowired
    public ZupanijaRepositoryImpl(JdbcTemplate jdbc, RowMapperCustom rowMapperCustom) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("zupanija")
                .usingGeneratedKeyColumns("sifZupanija");
        this.rowMapperCustom = rowMapperCustom;
    }

    @Override
    @Transactional
    public List<Zupanija> findZupanijaByPage(int page) {
        try {
            if(page < 1) {
                throw new RuntimeException("Page must not be smaller than 1");
            }
            Integer count = jdbc.queryForObject(SELECT_COUNT, rowMapperCustom::mapRowToCount);
            int offset = (page-1) * pageSize;
            if(offset >= count) {
                throw new RuntimeException("Offset must be smaller than the total number of elements");
            }
            return jdbc.query(SELECT_ALL + "LIMIT ? OFFSET ? ", rowMapperCustom::mapRowToZupanija, pageSize, offset);

        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
