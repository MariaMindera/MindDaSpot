package com.mindera.school.music.data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Table<TRow extends Row> extends Component {
    protected final List<TRow> backend;
    private int id = 1;

    public Table() {
        this.backend = new ArrayList<>();
    }

    public void add(TRow row) {
        this.backend.add(row);
        id++;
    }

    public void remove(int id) {
        for (int i = 0; i < this.backend.size(); i++) {
            if (this.backend.get(i).getId() == id) {
                this.backend.remove(i);
                break;
            }
        }
    }

    public TRow findById(int id) {
        for (TRow row : this.backend) {
            if (row.getId() == id) {
                return row;
            }
        }
        return null;
    }

    public int findIdByName(String name) {
        for (TRow tRow : this.backend) {
            if (tRow.getName().toUpperCase().equals(name.toUpperCase())) {
                return tRow.getId();
            }
        }
        return 0;
    }

    public List<TRow> findAll() {
        return this.backend;
    }

    public int getNewId() {
        return id;
    }

    public boolean verifyIfExistsName(String name) {
        for (TRow tRow : this.backend) {
            if (tRow.getName().toUpperCase().equals(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}