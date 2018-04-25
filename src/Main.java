import java.util.List;

public class Main {

    public static void main(String[] args) {
        int NUMBER_OF_POINTS = 5000;
        int RANDOM_POINTS_BOUND = 50;

        PointsFactory pointsFactory = new PointsFactory();
        List<Point> points = pointsFactory.genereatePoints(NUMBER_OF_POINTS, RANDOM_POINTS_BOUND);

        long startTime = System.currentTimeMillis();
        Pair bruteForceClosestPair = ClosestPair.bruteForce(points);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Brute force (" + elapsedTime + " ms): " + bruteForceClosestPair);

        startTime = System.currentTimeMillis();
        Pair dqClosestPair = ClosestPair.divideAndConquer(points);
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Divide and conquer (" + elapsedTime + " ms): " + dqClosestPair);
        if (bruteForceClosestPair.distance != dqClosestPair.distance)
            System.out.println("MISMATCH");
    }
}