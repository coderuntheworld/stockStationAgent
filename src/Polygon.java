/*
Filename:       Polygon.java
Course:         SENG2200 - Programming Languages and Paradigms
Assignment:     1
Student Name:   Isabella Andrews
Student No.:    C3204936
Program:        Bachelor of Software Engineering (Honours)
*/

public class Polygon implements ComparePoly {

    private Point[] pointsArray;
    private int pointTotal;
    private int givenTotal;
    private double closestPointToOrigin;
    private double area;

    // Default Constructor
    public Polygon() {}

    public Polygon(int point) {
        this.pointsArray = new Point[point];
        givenTotal = point;
    }

    public void addPointsToPolygon(double x, double y){
        Point point = new Point(x, y);
        pointsArray[pointTotal] = point;
        pointTotal++;
    }

    public double getArea(){
        return area;
    }

    public void calculateArea() {
        area = 0;
        for (int i = 0; i < givenTotal; i++) {
            // Set x and y coordinates to calculate area
            double x1 = pointsArray[i].getX();
            double x2 = i == givenTotal -1 ? pointsArray[0].getX() : pointsArray[i+ 1].getX();
            double y1 = pointsArray[i].getY();
            double y2 = i == givenTotal -1 ? pointsArray[0].getY() :  pointsArray[i + 1].getY();

            area += (x2 + x1) * (y2 - y1);
        }

        // Ensure absolute value
        area = Math.abs(area);

        // Final area calculation
        area = area/2;
    }

    private double calculateClosestPointToOrigin(){
        for (int i = 0; i < pointTotal; i++){
            if (pointsArray[i].getDistance() < closestPointToOrigin){
                closestPointToOrigin = pointsArray[i].getDistance();
            }
        }
        return closestPointToOrigin;
    }

    @Override
    public boolean ComesBefore(Object o) {
        Polygon p2 = (Polygon) o;

        if( p2 == null ) {
            return true;
        }

        double areaP1 = area;
        double areaP2 = p2.getArea();

        double margin = 0.001;
        double marginDifference;

        double distanceP1 = calculateClosestPointToOrigin();
        double distanceP2 = p2.calculateClosestPointToOrigin();

        // Calculate the difference in area
        double areaDifference = areaP1 - areaP2;

        // Ensure the absoluter value
        areaDifference = Math.abs(areaDifference);

        // Calculate the margin of difference
        if (area - p2.getArea() < 0){
            marginDifference = margin * areaP1;
        } else {
            marginDifference = margin * areaP2;
        }

        // Compare area difference to margin difference
        if (areaDifference < marginDifference){
            return !(distanceP1 < distanceP2);
        }
        return areaP1 < areaP2;
    }

    @Override
    public String toString() {
        String polyToString = "[";
        for (int i = 0; i < pointTotal; i++){
            polyToString += pointsArray[i].toString();
        }
        polyToString += "]";
        polyToString += String.format("%6.2f", area);
        return polyToString;
    }
}
