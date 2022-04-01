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
    }

    // Getter and Setter methods
    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distance;
    }

    @Override
    public String toString() {
        return "(" + String.format("%6.2f", x) + "," +  String.format("%6.2f", y) + ")";
    }
}
