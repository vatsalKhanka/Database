package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static Database database;
    public static File file;

    public static void main(String[] args) {
        file = new File("src/main/resources/database.dat");
        if(file.exists()) {
            System.out.println("FIle exists!!");
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                database = (Database) ois.readObject();
                System.out.println("Got data!");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            database = new Database();
            System.out.println("Creating database!");
            file.getParentFile().mkdirs();
        }

        CLI.cliLoop();
    }

    public static void writeToDatabase() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(database);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}