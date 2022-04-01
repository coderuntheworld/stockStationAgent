public class Polygon {

    private Point[] polygon;
    private int pointTotal;
    private double len;
    private double area;
    private double pointDistance;


    // Default Constructor
    public Polygon() {
    }

    public Polygon(int points) {
        polygon = new Point[points];
        pointTotal = 0;
        len = points;
        pointDistance = 0;
    }

    public void addPointsToPolygon(double x, double y){
        polygon[pointTotal] = new Point(x, y);
        pointTotal++;
    }

    public String polygonToString() {
        StringBuilder polyToString = new StringBuilder();
        for (int i = 0; i < pointTotal; i++){
            polyToString.append(" ").append(polygon[i].pointToString());
        }
        polyToString.append("[").append(polyToString).append("] ");
        polyToString.append(String.format("%6.2f", area));
        return polyToString.toString();
    }

    private void calculateArea() {
        double area = 0;
        for (int i = 0; i < pointTotal - 1; i++) {
            double x = polygon[i].getX();
            double y = polygon[i + 1].getY();
            area += x + y * x - y;
        }
        // Ensure absolute value
        if (area < 0){
            area *= -1;
        }
        area /= 2;
    }
}
