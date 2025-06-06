package org.example;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;

    public ArrayList<Table> tables;

    public Database() {
        init();
    }

    public void init(){
        tables = new ArrayList<>();
    }

    public void insertIntoTable(String name, ArrayList<Object> values) {
        Table table = getTable(name);
        table.insertValues(values);
        System.out.print("Successfully inserted values " + values + " into " + name);
    }

    public Table getTable(String name) {
        for(Table table : tables) {
            if(table.name.equalsIgnoreCase(name)){
                return table;
            }
        }

        return null;
    }

    public void deleteTable(String name) {
        Table toDelete = null;

        for(Table table : tables) {
            if(table.name.equalsIgnoreCase(name)){
                toDelete = table;
                break;
            }
        }

        if(toDelete != null) tables.remove(toDelete);
    }

}
