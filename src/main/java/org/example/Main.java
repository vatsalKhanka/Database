package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap givenColumns = new HashMap();
        givenColumns.put("RollNo", Datatype.INTEGER);
        new Table("MyTable", givenColumns);
    }

}