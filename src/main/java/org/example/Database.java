package org.example;

import java.util.ArrayList;

public class Database {

    public static ArrayList<Table> tables;

    public static void init(){
        tables = new ArrayList<>();
    }

    public static void insertIntoTable(String name, ArrayList<Object> values) {
        for(Table table : tables) {
            if(table.name.equalsIgnoreCase(name)){
                System.out.println(String.valueOf(values));
                table.insertValues(values);
                table.print();
                return;
            }
        }
    }

}
