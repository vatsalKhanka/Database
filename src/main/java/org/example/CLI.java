package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CLI {

    public static void cliLoop() {
        Scanner inputScanner = new Scanner(System.in).useDelimiter(";");
        while(true) {
            System.out.print("database> ");
            executeCommand(inputScanner.next());
        }
    }

    public static void executeCommand(String command) {
        System.out.println(command);
        String[] args = command.split(" ");
        System.out.println(Arrays.toString(args));
        if("create".equals(args[0])) {
            String tableCommand = command.replace(args[0] + " ", "");
            String name = tableCommand.substring(0, tableCommand.indexOf("("));
            System.out.println(name);
        }
    }

}
