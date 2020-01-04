package com.mindera.school.music.actions.producer;

import com.mindera.school.music.services.ProducerService;
import com.mindera.school.music.ui.Action;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.PRODUCER_SERVICE;

public class PrintAllProducersAction implements Action {
    private ProducerService producerService;

    public PrintAllProducersAction() {
        this.producerService = PRODUCER_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        producerService.printAll();
    }
}
