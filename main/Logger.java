package main;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;


public class Logger{
    private boolean console;
    public Logger(boolean console){
        this.console = console;
    }
    public void log(String type, String message){
        Date now = new Date();
        now.getDate();
        if (console){
            System.out.format("%s\n \t type: %s, message: %s\n", now, type, message);
        }else{
            try {
                File path = new File("logcsv.csv");
                PrintWriter writer = new PrintWriter(path);
                writer.format("%s\n \t type: %s, message: %s\n", now, type, message);
                writer.close();
            }
            catch (FileNotFoundException o) {};
        }
    }
    public void println(String message) {
        System.out.println(message);
    }
}