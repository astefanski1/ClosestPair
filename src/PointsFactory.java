import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointsFactory {

    public List<Point> genereatePoints(int numberOfPoints, int point_bound) {
        List<Point> points = new ArrayList<>();
        Random r = new Random();
        int randomMultiplyX, randomMultiplyY;
        for (int i = 0; i < numberOfPoints; i++) {
            randomMultiplyX = r.nextInt(point_bound);
            randomMultiplyY = r.nextInt(point_bound);
            points.add(new Point(r.nextDouble() + randomMultiplyX, r.nextDouble() + randomMultiplyY));
        }
        System.out.println("Generated " + numberOfPoints + " random points");
//        points.forEach((point) -> System.out.println("X: " + point.x + " Y: " + point.y));

        return points;
    }

}
