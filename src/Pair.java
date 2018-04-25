public class Pair {

    public Point point1 = null;
    public Point point2 = null;
    public double distance = 0.0;

    public Pair() {
    }

    public Pair(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        calcDistance();
    }

    public void update(Point point1, Point point2, double distance) {
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
    }

    public void calcDistance() {
        this.distance = distance(point1, point2);
    }

    public double distance(Point point1, Point point2) {
        double xdist = point2.x - point1.x;
        double ydist = point2.y - point1.y;
        return Math.hypot(xdist, ydist);
    }

    public String toString() {
        return point1 + "-" + point2 + " : " + distance;
    }
}