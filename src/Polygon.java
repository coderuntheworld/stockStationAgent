public class Polygon implements ComparePoly {

    private Point point;
    private Point[] points;
    private int pointTotal;
    private double closestPointToOrigin;
    private double area;
    private double pointDistance;

    // Default Constructor
    public Polygon() {}

    public Polygon(int points) {
        this.points = new Point[points];
        pointTotal = 0;
        pointDistance = 0;
        calculateArea();
        calculateClosestPointToOrigin();
    }

    public void addPointsToPolygon(double x, double y){
        Point point = new Point(x, y);
        points[pointTotal] = point;
        pointTotal++;
    }

    public double getArea(){
        return area;
    }

    public double getPointDistance(){
        return pointDistance;
    }

    private void calculateArea() {
        for (int i = 0; i < pointTotal - 1; i++) {
            double x = points[i].getX();
            double y = points[i + 1].getY();
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
            if (points[i].getDistance() < closestPointToOrigin){
                closestPointToOrigin = points[i].getDistance();
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

        double distanceP1 = pointDistance;
        double distanceP2 = p2.getPointDistance();

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
        StringBuilder polyToString = new StringBuilder();
        for (int i = 0; i < pointTotal; i++){
            polyToString.append(" ").append(points[i].toString());
        }
        polyToString.append("[").append(polyToString).append("] ");
        polyToString.append(String.format("%6.2f", area));
        return polyToString.toString();
    }
}
