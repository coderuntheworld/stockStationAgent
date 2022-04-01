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

        MyPolygons myPolygons = new MyPolygons();
        MyPolygons sortedPolygons = new MyPolygons();

        try {
            Scanner file = new Scanner(new File(args[0]));
            String input;

            while (file.hasNext()){
                input = file.next();

                if (input.equals("P")){
                    int numPoints = file.nextInt();
                    int pointCount = 1;

                    Polygon newPolygon = new Polygon(numPoints);

                    while (pointCount <= numPoints){
                        double x = file.nextDouble();
                        double y = file.nextDouble();
                        newPolygon.addPointsToPolygon(x, y);
                        pointCount++;
                    }
                    newPolygon.calculateArea();
                    myPolygons.append(newPolygon);
                }
            }

            // Sort polygons into increasing area order
            int myPolygonsSize = myPolygons.getSize();
            myPolygons.reset();
            sortedPolygons.reset();
            for (int i = 0; i < myPolygonsSize; i++){
                Polygon tempPolygon = myPolygons.next();
                sortedPolygons.insertInOrder(tempPolygon, myPolygonsSize);
            }

            // Print Unsorted and Sorted lists to console
            System.out.println("Unsorted list");
            System.out.println(myPolygons);
            System.out.println("Sorted list");
            System.out.println(sortedPolygons);
            System.out.println("End of Assignment.");

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