package org.example;

import java.time.Instant;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedHashMap<String, Datatype> givenColumns = new LinkedHashMap<>();
        givenColumns.put("RollNo", Datatype.INTEGER);
        givenColumns.put("Marks", Datatype.INTEGER);
        givenColumns.put("Name", Datatype.STRING);
        givenColumns.put("Date", Datatype.DATE);
        Table mytable = new Table("MyTable", givenColumns);
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(122);
        row1.add("Rio");
        row1.add(Date.from(Instant.now()));
        mytable.insertValues(row1);
        mytable.print();
        CLI.cliLoop();
    }

}