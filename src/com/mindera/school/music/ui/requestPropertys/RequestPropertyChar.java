package com.mindera.school.music.ui.requestPropertys;

import com.mindera.school.music.ui.KeyValue;
import com.mindera.school.music.ui.RequestProperty;

import java.util.Scanner;

public class RequestPropertyChar implements RequestProperty {
    private final Scanner SCANNER = new Scanner(System.in);
    private String name;
    private String question;

    public RequestPropertyChar(String name, String question) {
        this.name = name;
        this.question = question;
    }

    @Override
    public KeyValue ask() {
        System.out.print(question);
        return new KeyValue(name, SCANNER.next().trim().charAt(0));
    }
}
