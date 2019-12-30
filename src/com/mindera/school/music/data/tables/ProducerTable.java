package com.mindera.school.music.data.tables;

import com.mindera.school.music.data.Table;
import com.mindera.school.music.data.rows.Producer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerTable extends Table {
    public ProducerTable(String table) {
        super(table);
    }

    public void add(Producer producer) throws SQLException {
        sql.statement.executeUpdate("Call add_producer('" + producer.getName() + "');");
    }

    public Producer findById(int id) throws SQLException {
        ResultSet resultSet = sql.statement.executeQuery("Call get_producer_by_id(" + id + ");");

        if (resultSet.next()) {
            return new Producer(resultSet.getInt(1), resultSet.getString(2));
        }

        return null;
    }

    public List<Producer> findAll() throws SQLException {
        List<Producer> list = new ArrayList<>();

        ResultSet resultSet = sql.statement.executeQuery("Call get_all_producer();");

        while (resultSet.next()) {
            list.add(new Producer(resultSet.getInt(1), resultSet.getString(2)));
        }

        return list;
    }
}
