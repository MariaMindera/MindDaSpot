package com.mindera.school.music.ui.requestPropertys;

import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.RequestProperty;

import java.time.Year;
import java.util.Scanner;

public class RequestPropertyYear implements RequestProperty {
    private final Scanner SCANNER = new Scanner(System.in);
    private String name;
    private String question;

    public RequestPropertyYear(String name, String question) {
        this.name = name;
        this.question = question;
    }

    @Override
    public KeyValue ask() {
        System.out.print(question);
        int value = SCANNER.nextInt();
        while (value > Integer.parseInt(Year.now().toString()) || value <= 0) {
            System.out.print("Invalid year. Insert again: ");
            value = SCANNER.nextInt();
        }
        return new KeyValue(name, value);
    }
}