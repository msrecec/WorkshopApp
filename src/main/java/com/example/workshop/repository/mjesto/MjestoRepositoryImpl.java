package com.example.workshop.repository.mjesto;

import com.example.workshop.mappings.rowMapper.RowMapperCustom;
import com.example.workshop.model.count.Count;
import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.mjesto.MjestoPaginated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MjestoRepositoryImpl implements MjestoRepository{

    private static final String SELECT_ALL = "SELECT * FROM mjesto ";
    private static final String SELECT_COUNT = "SELECT COUNT(*) FROM mjesto ";
    private static final int pageSize = 10;
    private final RowMapperCustom rowMapperCustom;

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    @Autowired
    public MjestoRepositoryImpl(JdbcTemplate jdbc, RowMapperCustom rowMapperCustom) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("mjesto")
                .usingGeneratedKeyColumns("pbrMjesto");
        this.rowMapperCustom = rowMapperCustom;
    }

    @Override
    public Optional<MjestoPaginated> findMjestoByPage(int page) {
        try {
            if(page < 1) {
                throw new RuntimeException("Page must not be smaller than 1");
            }
            Optional<Count> count = findMjestoCount();
            if(count.isEmpty()) {
                throw new RuntimeException("Count must not be empty");
            }
            int offset = (page-1) * pageSize;
            if(offset >= count.get().getCount()) {
                throw new RuntimeException("Offset must be smaller than the total number of elements");
            }
            List<Mjesto> mjesta = jdbc.query(SELECT_ALL + "LIMIT ? OFFSET ? ", rowMapperCustom::mapRowToMjesto, pageSize, offset);
            return Optional.ofNullable(new MjestoPaginated(mjesta, count.get().getCount()));

        } catch (RuntimeException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Count> findMjestoCount() {
        try {
            return Optional.ofNullable(jdbc.queryForObject(SELECT_COUNT, rowMapperCustom::mapRowToCount));
        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }
}
