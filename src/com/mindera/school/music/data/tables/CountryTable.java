package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryTable extends Table {
    public CountryTable(String table) {
        super(table);
    }

    public void add(Country country) throws SQLException {
        sql.statement.executeUpdate("Call add_country('" + country.getName() + "');");
    }

    public Country findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_country_by_id(" + id + ");");

        if (resultSet.next()) {
            return new Country(resultSet.getInt(1), resultSet.getString(2));
        }

        return null;
    }

    public List<Country> findAll() throws SQLException {
        List<Country> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_country();");

        while (resultSet.next()) {
            list.add(new Country(resultSet.getInt(1), resultSet.getString(2)));
        }

        return list;
    }
}
