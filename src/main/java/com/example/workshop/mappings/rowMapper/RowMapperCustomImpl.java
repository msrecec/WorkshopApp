package com.example.workshop.mappings.rowMapper;

import com.example.workshop.model.count.Count;
import com.example.workshop.model.mjesto.Mjesto;
import com.example.workshop.model.zupanija.Zupanija;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RowMapperCustomImpl implements RowMapperCustom {
    public Count mapRowToCount(ResultSet rs, int rowNum) throws SQLException {
        return new Count(rs.getInt(1));
    }
    public Zupanija mapRowToZupanija(ResultSet rs, int rowNum) throws SQLException {
        return new Zupanija(rs.getLong(1), rs.getString(2), null);
    }
    @Override
    public Mjesto mapRowToMjesto(ResultSet rs, int rowNum) throws SQLException {
        return new Mjesto(rs.getLong(1), rs.getString(2), null);
    }
}
