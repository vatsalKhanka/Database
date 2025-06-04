package org.example;

import java.util.ArrayList;

public class Database {

    public static ArrayList<Table> tables;

    public static void init(){
        tables = new ArrayList<>();
    }

    public static void insertIntoTable(String name, ArrayList<Object> values) {
        Table table = getTable(name);
        table.insertValues(values);
        System.out.print("Successfully inserted values " + values + " into " + name);
    }

    public static Table getTable(String name) {
        for(Table table : tables) {
            if(table.name.equalsIgnoreCase(name)){
                return table;
            }
        }

        return null;
    }

}
