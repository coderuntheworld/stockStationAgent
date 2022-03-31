/*
Filename:       A1.java
Course:         SENG2200 - Programming Languages and Paradigms
Assignment:     1
Student Name:   Isabella Andrews
Student No.:    C3204936
Program:        Bachelor of Software Engineering (Honours)
*/

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class a1 {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner file = new Scanner(new File(args[0]));

            MyPolygons myPolygons = new MyPolygons();

            System.out.println("Unsorted list\n" + myPolygons.toString() + "\n");
            System.out.println("Sorted list");

        } catch (Exception e){
            // Error Logging
            String date = new SimpleDateFormat("yy-MM-dd HH.mm.ss").format(new Date());
            FileOutputStream fileOutputStream = new FileOutputStream("logs/Error_" + date + ".txt");
            PrintStream printStream = new PrintStream((fileOutputStream));
            System.setErr(printStream);
            System.err.append(date).append(" ").append(String.valueOf(e)).append("\n\n");
            e.printStackTrace();
            printStream.close();
        }

    }
}
