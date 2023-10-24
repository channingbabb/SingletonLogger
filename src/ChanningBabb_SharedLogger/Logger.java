package ChanningBabb_SharedLogger;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class Logger {
    private final String LOG_FILE = "log.txt";
    private static Logger instance;

    private Logger() {
        File file = new File(LOG_FILE);
        if (!file.exists()) {
            try {
                boolean result = file.createNewFile();
                if (result) {
                    System.out.println("File created successfully");
                } else {
                    System.out.println("File already exists/error creating file");
                }
            } catch (Exception e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
    }


    public static Logger getInstance() {
        if(instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void writeToFile(String message) {
        // write message to file
        File file = new File(LOG_FILE);
        // if file exists, write to it
        if (file.exists()) {
            try {
                // create a new FileWriter object
                FileWriter writer = new FileWriter(file, true);
                // write the message to the file
                writer.write(message + "\n");
                // close the writer
                writer.close();
            } catch (Exception e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist");
        }
    }

    public void log(String message, int priority) {
        if (priority == 3 || priority == 2 || priority == 1) {
            LocalDateTime now = LocalDateTime.now();
            String stringPriority = switch (priority) {
                case 3 -> "LOW";
                case 2 -> "MEDIUM";
                case 1 -> "HIGH";
                default -> "";
            };
            String output = "(" + now + ") " + stringPriority + " priority - " + message;
            System.out.println(output);
            writeToFile(output);
        } else {
            // throw new IllegalArgumentException("Invalid priority level");
            throw new IllegalArgumentException("Invalid priority level: " + priority);
        }
    }

}