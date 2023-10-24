package ChanningBabb_SharedLogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "log.txt"; // static variable that holds the name of the log file
    private static Logger instance; // static variable that holds the instance of the Logger class

    // private constructor that can only be accessed from within the class
    private Logger() {
        File file = new File(LOG_FILE); // create a new File object
        if (!file.exists()) {
            try {
                boolean result = file.createNewFile(); // create a new file if one does not already exist
                if (result) { // print a message if the file was created successfully
                    System.out.println("File created successfully");
                } else { // print a message if the file already exists or an error occurred
                    System.out.println("File already exists/error creating file");
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage()); // print the error message if an error occurs
            }
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // create a new instance of the Logger class if one does not already exist
        }
        return instance;
    }

    public void log(String message, int priority) {
        if (priority < 1 || priority > 3) {
            throw new IllegalArgumentException("Invalid priority level: " + priority); // throw an exception if the priority level is invalid
        }
        LocalDateTime now = LocalDateTime.now(); // get the current date and time
        String stringPriority = switch (priority) { // convert the priority level to a string
            case 3 -> "LOW";
            case 2 -> "MEDIUM";
            case 1 -> "HIGH";
            default -> "";
        };
        String output = "(" + now + ") " + stringPriority + " priority - " + message; // output message for the log file and console
        System.out.println(output);
        writeToFile(output);
    }

    // private synchronized means that only one thread can access this method at a time
    private synchronized void writeToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) { // create a new BufferedWriter and FileWriter to write to the file
            writer.write(message + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage()); // print the error message if an error occurs
        }
    }
}