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

public class A1 {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            Scanner file = new Scanner(new File(args[0]));
            String input;
            MyPolygons myPolygons = new MyPolygons();

            while (file.hasNext()){
                input = file.next();

                if (input.equals("P")){
                    int points = file.nextInt();
                    int pointCount = 1;
                    int i = 0;

                    Point[] newPoint = new Point[points];
                    Polygon newPolygon = new Polygon(points);

                    while (pointCount <= points){
                        double x = file.nextDouble();
                        double y = file.nextDouble();
                        newPoint[i] = new Point(x, y);
                        newPolygon.addPointsToPolygon(x, y);
                        pointCount++;
                        i++;
                    }
                    myPolygons.append(newPolygon);
                }
            }

            System.out.println("Unsorted list\n" + myPolygons + "\n");
            System.out.println("Sorted list");

        } catch (Exception e){
            // Error Logging
            String date = new SimpleDateFormat("yy-MM-dd_HH.mm.ss").format(new Date());
            FileOutputStream fileOutputStream = new FileOutputStream("logs/Error_" + date + "_" + e.getClass() + ".txt");
            PrintStream printStream = new PrintStream((fileOutputStream));
            System.setErr(printStream);
            System.err.append(date).append(" ").append(String.valueOf(e)).append("\n\n");
            e.printStackTrace();
            printStream.close();
        }

    }
}
