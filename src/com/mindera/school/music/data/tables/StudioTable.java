package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Studio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudioTable extends Table {
    public StudioTable(String table) {
        super(table);
    }

    public void add(Studio studio) throws SQLException {
        sql.statement.executeUpdate("Call add_studio('" + studio.getName() + "', '" + studio.getCity() + "', "
                + studio.getCountryId() + ");");
    }

    public Studio findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_studio_by_id(" + id + ");");

        if (resultSet.next()) {
            return new Studio(resultSet.getInt("studio_id"), resultSet.getString("name"),
                    resultSet.getString("city"), resultSet.getInt("country_id"));
        }

        return null;
    }

    public List<Studio> findAll() throws SQLException {
        List<Studio> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_studio();");

        while (resultSet.next()) {
            list.add(new Studio(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4)));
        }

        return list;
    }
}
