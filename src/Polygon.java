public class Polygon implements ComparePoly {

    private Point point;
    private Point[] pointsArray;
    private int pointTotal;
    private double closestPointToOrigin;
    private double area;

    // Default Constructor
    public Polygon() {}

    public Polygon(int point) {
        this.pointsArray = new Point[point];
        calculateArea();
        calculateClosestPointToOrigin();
        //System.out.println("Area: " + area);
        //System.out.println("Point to Origin: " + closestPointToOrigin);
    }

    public void addPointsToPolygon(double x, double y){
        Point point = new Point(x, y);
        pointsArray[pointTotal] = point;
        pointTotal++;
    }

    public double getArea(){
        return area;
    }

    public double getClosestPointToOrigin() {
        return closestPointToOrigin;
    }

    private void calculateArea() {
        for (int i = 0; i < pointTotal - 1; i++) {
            double x = pointsArray[i].getX();
            double y = pointsArray[i + 1].getY();
            area += x + y * x - y;
        }
        // Ensure absolute value
        if (area < 0){
            area *= -1;
        }
        area /= 2;
    }

    private void calculateClosestPointToOrigin(){
        for (int i = 0; i < pointTotal; i++){
            if (pointsArray[i].getDistance() < closestPointToOrigin){
                closestPointToOrigin = pointsArray[i].getDistance();
            }
        }
    }

    @Override
    public boolean ComesBefore(Object o) {
        Polygon p2 = (Polygon) o;

        double areaP1 = area;
        double areaP2 = p2.getArea();

        double margin = 0.001;
        double marginDifference;

        double distanceP1 = closestPointToOrigin;
        double distanceP2 = p2.getClosestPointToOrigin();

        // Calculate the difference in area
        double areaDifference = areaP1 - areaP2;

        // Ensure the absoluter value
        if (areaDifference < 0){
            areaDifference *= -1;
        }

        // Calculate the margin of difference
        if (area - p2.getArea() < 0){
            marginDifference = margin * areaP1;
        } else {
            marginDifference = margin * areaP2;
        }

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
