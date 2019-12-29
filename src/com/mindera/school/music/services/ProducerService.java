package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.Producer;
import com.mindera.school.music.data.tables.ProducerTable;
import com.mindera.school.music.ui.KeyValue;

import java.sql.SQLException;
import java.util.List;

import static com.mindera.school.music.data.tables.Tables.*;

public class ProducerService {
    ProducerTable producerTable;

    public ProducerService() {
        this.producerTable = PRODUCER_TABLE;
    }

    public void add(List<KeyValue> keyValueList) throws SQLException {
        Producer producer = new Producer();

        for (KeyValue keyValue : keyValueList) {
            if (keyValue.getName().equals("Name")) {
                if(producerTable.verifyIfExistsName(keyValue.getValue().toString())) {
                    System.out.println("This producer already exits.");
                    return;
                }
                producer.setName(keyValue.getValue().toString());
            }
        }

        producerTable.add(producer);
    }

    public void removeById(int id) throws SQLException {
        producerTable.removeById(id);
    }

    public void removeByName(String name) throws SQLException {
        producerTable.removeByName(name);
    }

    public Producer find(int id) throws SQLException {
        return producerTable.findById(id);
    }

    public List<Producer> findAll() throws SQLException {
        return producerTable.findAll();
    }

    public void printAll() throws SQLException {
        List<Producer> producerList = findAll();

        if(producerList.isEmpty()) {
            System.out.println("There is no producers.");
            return;
        }

        for (Producer producer : producerList) {
            System.out.println("Producer id: " + producer.getId());
            System.out.println("Name: " + producer.getName() + '\n');
        }
    }

    public void print(int id) throws SQLException {
        Producer producer = find(id);

        if(producer == null) {
            System.out.println("There is no producer.");
            return;
        }

        System.out.println("Producer id: " + producer.getId());
        System.out.println("Name: " + producer.getName() + '\n');
    }
}
