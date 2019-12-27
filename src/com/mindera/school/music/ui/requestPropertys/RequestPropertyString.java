package com.mindera.school.music.ui.requestPropertys;

import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.RequestProperty;

import java.util.Scanner;

public class RequestPropertyString implements RequestProperty {
    private final Scanner SCANNER = new Scanner(System.in);
    private String name;
    private String question;

    public RequestPropertyString(String name, String question) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
        this.question = question;
    }

    @Override
    public KeyValue ask() {
        System.out.print(question);
        String value = SCANNER.nextLine().trim();
        return new KeyValue(name, value);
    }
}
