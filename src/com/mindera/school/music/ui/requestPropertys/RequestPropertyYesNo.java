package com.mindera.school.music.ui.requestPropertys;

import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.RequestProperty;

import java.util.Scanner;

public class RequestPropertyYesNo implements RequestProperty {
    private final Scanner SCANNER = new Scanner(System.in);
    private String name;
    private String question;

    public RequestPropertyYesNo(String name, String question) {
        this.name = name;
        this.question = question;
    }

    @Override
    public KeyValue ask() {
        System.out.print(question);
        char value = SCANNER.next().charAt(0);
        while (true) {
            if (value == 'Y' || value == 'y') {
                return new KeyValue(name, value);
            }
            if (value == 'N' || value == 'n') {
                return new KeyValue(name, value);
            }
            System.out.print("Invalid letter. Insert again: ");
            value = SCANNER.next().charAt(0);
        }
    }
}
