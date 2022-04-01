/*
Filename:       Point.java
Course:         SENG2200 - Programming Languages and Paradigms
Assignment:     1
Student Name:   Isabella Andrews
Student No.:    C3204936
Program:        Bachelor of Software Engineering (Honours)
*/

public class Point {

    // x Coordinate
    double x;
    // y Coordinate
    double y;
    // Distance between x and y coordinates
    double distance;

    // Default Constructor
    public Point() {}

    // Initialise Point Variables
    public Point(double initX, double initY){
        x = initX;
        y = initY;
        distance = 0;
    }

    // Setter and Getter methods
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance() {
        distance = Math.sqrt(((x * x) + (y + y)));
        return distance;
    }

    public String pointToString() {
        return "(" + String.format("%6.2f", x) + " , " +  String.format("%6.2f", y) + ")";
    }
}
