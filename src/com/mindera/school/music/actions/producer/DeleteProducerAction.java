package com.mindera.school.music.actions.producer;

import com.mindera.school.music.services.ProducerService;
import com.mindera.school.music.ui.Action;
import com.mindera.school.music.ui.Request;

import java.sql.SQLException;

import static com.mindera.school.music.services.Services.PRODUCER_SERVICE;

public class DeleteProducerAction implements Action {
    private ProducerService producerService;

    public DeleteProducerAction() {
        this.producerService = PRODUCER_SERVICE;
    }

    @Override
    public void execute() throws SQLException {
        Request request = new Request();
        request.hasString("Name", "Insert the name of the producer: ");
        producerService.removeByName(request.ask().get(0).getValue().toString());
    }
}
