package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //logs Launching the application
        logAction("launch");

        //logs searching for a term
        while (true) {
            System.out.println("Enter search term (X or x to exit): ");
            String searchTerm = input.nextLine().trim();

            //exit loop if user choose exit
            if (searchTerm.equalsIgnoreCase("X")) {
                break;
            }

            logAction("search : " + searchTerm);
        }

        //logs exiting the app
        logAction("exit");
    }

    //log the time of action user take & write it in txt file
    public static void logAction(String action){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String logTime = LocalDateTime.now().format(dtf);

        try {
            //Open logs.txt file and wrap it in buffer reader
            FileWriter fileWriter = new FileWriter("logs.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //Write log time and action taken name
            bufferedWriter.write(logTime + " " + action);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Could not write to log: " + e.getMessage());
        }
    }
}