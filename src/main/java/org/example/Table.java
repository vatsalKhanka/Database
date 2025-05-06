package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Table {

    private int numRows;
    private int numColumns;

    private HashMap<String, List<Object>> columns;
    private List<List<Object>> rows;

    public Table(String name, HashMap<String, Datatype> givenColumns) {
        columns = new HashMap<>();
        rows = new ArrayList<List<Object>>();

        for(String columnName : givenColumns.keySet()) {
            switch (givenColumns.get(columnName)){
                case INTEGER:
                    columns.put(columnName, (List) new ArrayList<Integer>());
                break;
            }
        }
    }

    private void updateRows() {
        for(int i = 0; i < columns.size(); i++) {
            ArrayList row = new ArrayList<Object>();

            for(List column : columns.values()){
                row.add(column.get(i));
            }

            rows.add(row);
        }
    }

    public void insertValues(List<Object> values) {

    }

    public int getRows() {
        return numRows;
    }

    public int getColumns() {
        return numColumns;
    }

}
