package org.example;

import java.io.Serializable;
import java.util.*;

public class Table implements Serializable {

    private static final long serialVersionUID = 652968509826775769L;

    private int numRows;
    private int numColumns;

    private final LinkedHashMap<String, List<Object>> columns;
    private final List<List<Object>> rows;

    private final LinkedHashMap<String, Datatype> tableStructure;

    public String name;

    public Table(String name, LinkedHashMap<String, Datatype> givenColumns) {
        tableStructure = givenColumns;

        columns = new LinkedHashMap<>();
        rows = new ArrayList<List<Object>>();

        this.name = name;

        for(String columnName : givenColumns.keySet()) {
            switch (givenColumns.get(columnName)){
                case INTEGER:
                    columns.put(columnName, (List) new ArrayList<Integer>());
                break;
                case STRING:
                    columns.put(columnName, (List) new ArrayList<String>());
                break;
                case DATE:
                    columns.put(columnName, (List) new ArrayList<Date>());
                break;
            }
        }
    }

    private void updateRows() {
        rows.clear();
        int length = columns.get(columns.keySet().toArray()[0]).size();
        for(int i = 0; i < length; i++) {
            ArrayList row = new ArrayList<Object>();

            for(List column : columns.values()){
                row.add(column.get(i));
            }

            rows.add(row);
        }
    }

    public void print() {
        if(rows.isEmpty()){
            System.out.println(name + " is an empty table, with the structure " + tableStructure);
            return;
        }

        Object[][] table = new Object[rows.size()+2][];
        table[0] = new Object[columns.keySet().size()];
        table[1] = columns.keySet().toArray();

        if((columns.keySet().size())%2==1){
            for(int i = 0; i < columns.keySet().size(); i++){
                if(i!=(columns.keySet().size()+1)/2){
                    table[0][i] = "";
                } else table[0][i] = name;
            }
        } else {
            for(int i = 0; i < columns.keySet().size(); i++){
                if(i!=(columns.keySet().size())/2){
                    table[0][i] = "";
                } else table[0][i] = name;
            }
        }

        for(List row : rows) {
            table[rows.indexOf(row)+2] = row.toArray();
        }

        String format = "";
        for(int i = 0; i < rows.get(0).size(); i++) {
            format += "%15s";
        }
        format += "%n";

        for (final Object[] row : table) {
            System.out.format(format, row);
        }
    }

    public void insertValues(List<Object> values) {
        for(Object o : values) {
            int index = values.indexOf(o);
            String columnName = (String) columns.keySet().toArray()[index];
            List newColumn = columns.get(columnName);
            newColumn.add(o);
            columns.put(columnName, newColumn);
        }

        updateRows();
    }

    public int getRows() {
        return numRows;
    }

    public int getColumns() {
        return numColumns;
    }

}
