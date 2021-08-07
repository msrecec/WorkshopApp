package com.example.workshop.mappings.rowMapper;

import com.example.workshop.model.count.Count;
import com.example.workshop.model.zupanija.Zupanija;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapperCustom {
    Count mapRowToCount(ResultSet rs, int rowNum) throws SQLException;
    Zupanija mapRowToZupanija(ResultSet rs, int rowNum) throws SQLException;
}
