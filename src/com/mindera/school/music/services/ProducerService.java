package com.mindera.school.music.services;

import com.mindera.school.music.data.rows.Genre;
import com.mindera.school.music.data.rows.Producer;
import com.mindera.school.music.data.tables.ProducerTable;
import com.mindera.school.music.ui.KeyValue;

import java.util.List;

import static com.mindera.school.music.data.tables.Tables.*;

public class ProducerService {
    ProducerTable producerTable;

    public ProducerService() {
        this.producerTable = PRODUCER_TABLE;
    }

    public void add(List<KeyValue> keyValueList) {
        Producer producer = new Producer();

        producer.setId(producerTable.getNewId());

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

    public void removeProducer(int id) {
        producerTable.remove(id);
    }

    public Producer findProducer(int id) {
        return producerTable.findById(id);
    }

    public List<Producer> findAllProducers() {
        return producerTable.findAll();
    }

    public void printAllProducers() {
        List<Producer> producerList = findAllProducers();

        if(producerList.isEmpty()) {
            System.out.println("There is no producer.");
            return;
        }

        for (Producer producer : producerList) {
            System.out.println("Producer id: " + producer.getId());
            System.out.println("Name: " + producer.getName() + '\n');
        }
    }

    public void printProducer(int id) {
        Producer producer = findProducer(id);
        if(producer == null) {
            System.out.println("There is no producer with this id.");
            return;
        }

        System.out.println("Producer id: " + producer.getId());
        System.out.println("Name: " + producer.getName() + '\n');
    }
}
