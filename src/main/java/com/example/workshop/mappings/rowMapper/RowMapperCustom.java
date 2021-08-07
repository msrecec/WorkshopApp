package com.example.workshop.mappings.rowMapper;

import com.example.workshop.model.zupanija.Zupanija;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapperCustom {
    Integer mapRowToCount(ResultSet rs, int rowNum) throws SQLException;
    Zupanija mapRowToZupanija(ResultSet rs, int rowNum) throws SQLException;
}
