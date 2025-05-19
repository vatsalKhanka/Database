package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap givenColumns = new HashMap();
        givenColumns.put("RollNo", Datatype.INTEGER);
        givenColumns.put("Marks", Datatype.INTEGER);
        givenColumns.put("Name", Datatype.STRING);
        Table mytable = new Table("MyTable", givenColumns);
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(122);
        row1.add("Rio");
        mytable.insertValues(row1);
        mytable.print();
    }

}