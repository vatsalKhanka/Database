package org.example;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLI {

    public static void cliLoop() {
        Scanner inputScanner = new Scanner(System.in).useDelimiter(";");
        while(true) {
            System.out.print("database> ");
            executeCommand(inputScanner.next());
        }
    }

    public static void executeCommand(String command) {
        command = command.replaceAll("\n", "");

        Pattern createTable = Pattern.compile("(?i)create\\s+table\\s+(\\w+)+\\((.*?)\\)");
        if(createTable.matcher(command).matches())createTable(command);

        Pattern insertTable = Pattern.compile("(?i)insert\\s+into\\s+(\\w+)+\\((.*?)\\)");
        if(insertTable.matcher(command).matches())insertValues(command);
    }

    public static void createTable(String command) {
        Pattern createTable = Pattern.compile("(?i)create\\s+table\\s+(\\w+)+\\((.*?)\\)");
        Matcher matcher = createTable.matcher(command);
        matcher.matches();

        LinkedHashMap tableStructure = new LinkedHashMap<String, Datatype>();

        for(String s : matcher.group(2).split(",")){
            s = s.trim();

            System.out.println(s.split(" ")[0]);
            System.out.println(s.split(" ")[1]);

            if(s.split(" ")[1].equalsIgnoreCase(Datatype.T_STRING)){
                tableStructure.put(s.split(" ")[0], Datatype.STRING);
            }

            if(s.split(" ")[1].equalsIgnoreCase(Datatype.T_INT)){
                tableStructure.put(s.split(" ")[0], Datatype.INTEGER);
            }
        }

        Table table = new Table(matcher.group(1),tableStructure);
        Database.tables.add(table);
    }

    public static void insertValues(String command) {
        Pattern createTable = Pattern.compile("(?i)insert\\s+into\\s+(\\w+)+\\((.*?)\\)");
        Matcher matcher = createTable.matcher(command);
        System.out.println(matcher.matches());
        System.out.println("INSERTING LESGO");

        ArrayList values = new ArrayList<Object>();

        for(String s : matcher.group(2).split(",")){
            s = s.trim();
            Object value = null;

            if(isNumeric(s)){
                value=Integer.parseInt(s);
            } else value = s;

            values.add(value);
        }

        String name = matcher.group(1);

        Database.insertIntoTable(name, values);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


}
