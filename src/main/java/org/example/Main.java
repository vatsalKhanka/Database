package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap givenColumns = new HashMap();
        givenColumns.put("RollNo", Datatype.INTEGER);
        givenColumns.put("Marks", Datatype.INTEGER);
        Table mytable = new Table("MyTable", givenColumns);
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add(1);
        mytable.insertValues(row1);
        mytable.print();
    }

}