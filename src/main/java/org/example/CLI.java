package org.example;

import java.util.ArrayList;
import java.util.Date;
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
        long startTime = System.currentTimeMillis();
        command = command.replaceAll("\n", "");

        boolean commandFound = false;

        Pattern createTable = Pattern.compile("(?i)create\\s+table\\s+(\\w+)+\\((.*?)\\)");
        if(createTable.matcher(command).matches()){
            createTable(command);
            commandFound = true;
        }

        Pattern insertTable = Pattern.compile("(?i)insert\\s+into\\s+(\\w+)+\\((.*?)\\)");
        if(insertTable.matcher(command).matches()) {
            insertValues(command);
            commandFound = true;
        }

        Pattern printTable = Pattern.compile("(?i)print\\s+table\\s+(\\w+)");
        if(printTable.matcher(command).matches()){
            printTable(command);
            commandFound = true;
        }

        if(command.equalsIgnoreCase("show tables")) {
            System.out.println("Tables currently in this database are: ");
            for(Table table : Database.tables) {
                System.out.println(table.name);
            }
            commandFound = true;
        }

        if(!commandFound){
            System.out.println("Invalid command.");
        } else System.out.println(" (" + (System.currentTimeMillis()-startTime) + " ms)");
    }

    public static void createTable(String command) {
        Pattern createTable = Pattern.compile("(?i)create\\s+table\\s+(\\w+)+\\((.*?)\\)");
        Matcher matcher = createTable.matcher(command);
        matcher.matches();

        LinkedHashMap tableStructure = new LinkedHashMap<String, Datatype>();

        for(String s : matcher.group(2).split(",")){
            s = s.trim();

            if(s.split(" ")[1].equalsIgnoreCase(Datatype.T_STRING)){
                tableStructure.put(s.split(" ")[0], Datatype.STRING);
            }

            if(s.split(" ")[1].equalsIgnoreCase(Datatype.T_INT)){
                tableStructure.put(s.split(" ")[0], Datatype.INTEGER);
            }

            if(s.split(" ")[1].equalsIgnoreCase(Datatype.T_DATE)){
                tableStructure.put(s.split(" ")[0], Datatype.DATE);
            }
        }

        Table table = new Table(matcher.group(1),tableStructure);
        Database.tables.add(table);

        System.out.print("Successfully created table " + matcher.group(1) + " with rows " + tableStructure);
    }

    public static void insertValues(String command) {
        Pattern insert = Pattern.compile("(?i)insert\\s+into\\s+(\\w+)+\\((.*?)\\)");
        Matcher matcher = insert.matcher(command);
        matcher.matches();

        ArrayList values = new ArrayList<Object>();

        for(String s : matcher.group(2).split(",")){
            s = s.trim();
            Object value = null;

            if(isNumeric(s)){
                value=Integer.parseInt(s);
            } else if(isDate(s)) {
                value = toDate(s);
            } else if(s.charAt(0) == '"' && s.charAt(s.length()-1) == '"'){
                value = s.substring(1, s.length()-1);
            }

            values.add(value);
        }

        String name = matcher.group(1);
        Database.insertIntoTable(name, values);
    }

    public static void printTable(String command) {
        Pattern printTable = Pattern.compile("(?i)print\\s+table\\s+(\\w+)");
        Matcher matcher = printTable.matcher(command);
        matcher.matches();

        Database.getTable(matcher.group(1)).print();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean isDate(String str) {
        Pattern datePattern = Pattern.compile("\\[(\\d+)/(\\d+)/(\\d+)]");
        Matcher matcher = datePattern.matcher(str);
        boolean matches = matcher.matches();

        int day, month, year;

        if(matches){
            day = Integer.parseInt(matcher.group(1));
            month = Integer.parseInt(matcher.group(2));
            year = Integer.parseInt(matcher.group(3));
        } else return false;

        boolean validDay = false;
        boolean validMonth = month <= 12 && month >= 1;

        if(!validMonth) return false;

        switch(month) {
            case 1, 3, 5, 7, 8, 10, 12:
                validDay = day <= 31;
                break;

            case 4, 6, 9, 11:
                validDay = day <= 20;
                break;

            case 2:
                if(year % 4 == 0 && year % 100 != 0) {
                    validDay = day <= 29;
                } else validDay = day <= 28;
                break;
        }

        return matches && validMonth && validDay;
    }

    public static Date toDate(String str) {
        if(isDate(str)){
            Pattern datePattern = Pattern.compile("\\[(\\d+)/(\\d+)/(\\d+)]");
            Matcher matcher = datePattern.matcher(str);
            matcher.matches();

            Date date = new Date(Integer.parseInt(matcher.group(3))-1900, Integer.parseInt(matcher.group(2))-1, Integer.parseInt(matcher.group(1)));
            return date;
        }

        return null;
    }
}
