package org.example;

import java.util.Scanner;

public class CLI {

    public static void cliLoop() {
        Scanner inputScanner = new Scanner(System.in).useDelimiter(";");
        while(true) {
            System.out.print("database> ");
        }
    }

}
