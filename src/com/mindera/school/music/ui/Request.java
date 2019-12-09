package com.mindera.school.music.ui;

import com.mindera.school.music.ui.requestPropertys.*;

import java.util.ArrayList;
import java.util.List;

public class Request {
    List<RequestProperty> properties;

    public Request() {
        properties = new ArrayList<>();
    }

    public void hasInt(String name, String question) {
        properties.add(new RequestPropertyInteger(name, question));
    }

    public void hasString(String name, String question) {
        properties.add(new RequestPropertyString(name, question));
    }

    public void hasChar(String name, String question) {
        properties.add(new RequestPropertyChar(name, question));
    }

    public void hasYear(String name, String question) {
        properties.add(new RequestPropertyYear(name, question));
    }

    public void hasYesNo(String name, String question) {
        properties.add(new RequestPropertyYesNo(name, question));
    }

    public List<KeyValue> ask() {
        List<KeyValue> keyValueList = new ArrayList<>();

        for (RequestProperty property : properties) {
            keyValueList.add(property.ask());
        }

        return keyValueList;
    }
}