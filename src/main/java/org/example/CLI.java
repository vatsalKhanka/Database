package org.example;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(command);
        Pattern createTable = Pattern.compile("(?i)create\\s+table\\s+(\\w+)");
        Matcher matcher = createTable.matcher(command);
        System.out.println(matcher.matches());
        System.out.println(matcher.find());
        System.out.println(matcher.groupCount());
        matcher.matches();
        System.out.println(matcher.group(1));
    }

}
