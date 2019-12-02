package com.mindera.school.music.data;

import java.util.ArrayList;
import java.util.List;

public class Table<TRow extends Row> {
    private final List<TRow> backend;

    public Table() {
        this.backend = new ArrayList<>();
    }

    public void add(TRow row) {
        this.backend.add(row);
    }

    public void remove(int id) {
        for(int i = 0; i < this.backend.size(); i++) {
            if(this.backend.get(i).getId() == id) {
                this.backend.remove(i);
                break;
            }
        }
    }

    public TRow find(int id) {
        for (TRow row: this.backend) {
            if(row.getId() == id) {
                return row;
            }
        }
        return null;
    }

    public List<TRow> findAll() {
        return this.backend;
    }
}