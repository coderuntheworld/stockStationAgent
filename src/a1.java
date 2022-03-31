/*
Filename:       A1.java
Course:         SENG2200 - Programming Languages and Paradigms
Assignment:     1
Student Name:   Isabella Andrews
Student No.:    C3204936
Program:        Bachelor of Software Engineering (Honours)
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class a1 {

    public static void main(String[] args) throws FileNotFoundException {

        File errorLog = new File("logs/stdErr.log");
        PrintStream printStream = new PrintStream(errorLog);
        String err = "";

        try {
            Scanner file = new Scanner(new File(args[0]));

            MyPolygons myPolygons = new MyPolygons();

            System.out.println("Unsorted list\n" + myPolygons.toString() + "\n");
            System.out.println("Sorted list");

        } catch (Exception e){
            e.printStackTrace(printStream);
        }
    }
}
