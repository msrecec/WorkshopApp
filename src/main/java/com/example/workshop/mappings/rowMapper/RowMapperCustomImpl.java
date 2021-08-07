package com.example.workshop.mappings.rowMapper;

import com.example.workshop.model.zupanija.Zupanija;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RowMapperCustomImpl implements RowMapperCustom {
    public Integer mapRowToCount(ResultSet rs, int rowNum) throws SQLException {
        return rs.getInt(1);
    }
    public Zupanija mapRowToZupanija(ResultSet rs, int rowNum) throws SQLException {
        return new Zupanija(rs.getLong(1), rs.getString(2), null);
    }
}
