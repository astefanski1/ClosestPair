import java.util.ArrayList;
import java.util.List;

public class ClosestPair {

    public static Pair bruteForce(List<? extends Point> points) {
        int numPoints = points.size();
        if (numPoints < 2)
            return null;
        Pair pair = new Pair(points.get(0), points.get(1));
        if (numPoints > 2) {
            for (int i = 0; i < numPoints - 1; i++) {
                Point point1 = points.get(i);
                for (int j = i + 1; j < numPoints; j++) {
                    Point point2 = points.get(j);
                    double distance = pair.distance(point1, point2);
                    if (distance < pair.distance)
                        pair.update(point1, point2, distance);
                }
            }
        }

        return pair;
    }

    public static Pair divideAndConquer(List<? extends Point> points) {
        SortPoints sort = new SortPoints();
        List<Point> pointsSortedByX = new ArrayList<>(points);
        sort.sortByX(pointsSortedByX);
        List<Point> pointsSortedByY = new ArrayList<>(points);
        sort.sortByY(pointsSortedByY);
        return divideAndConquer(pointsSortedByX, pointsSortedByY);
    }

    private static Pair divideAndConquer(List<? extends Point> pointsSortedByX, List<? extends Point> pointsSortedByY) {
        SortPoints sort = new SortPoints();
        Pair pair = new Pair();
        int numPoints = pointsSortedByX.size();
        if (numPoints <= 3)
            return bruteForce(pointsSortedByX);

        int dividingIndex = numPoints >>> 1;
        List<? extends Point> leftOfCenter = pointsSortedByX.subList(0, dividingIndex);
        List<? extends Point> rightOfCenter = pointsSortedByX.subList(dividingIndex, numPoints);

        List<Point> tempList = new ArrayList<>(leftOfCenter);
        sort.sortByY(tempList);
        Pair closestPair = divideAndConquer(leftOfCenter, tempList);

        tempList.clear();
        tempList.addAll(rightOfCenter);
        sort.sortByY(tempList);
        Pair closestPairRight = divideAndConquer(rightOfCenter, tempList);

        if (closestPairRight.distance < closestPair.distance)
            closestPair = closestPairRight;

        tempList.clear();
        double shortestDistance = closestPair.distance;
        double centerX = rightOfCenter.get(0).x;
        for (Point point : pointsSortedByY)
            if (Math.abs(centerX - point.x) < shortestDistance)
                tempList.add(point);

        for (int i = 0; i < tempList.size() - 1; i++) {
            Point point1 = tempList.get(i);
            for (int j = i + 1; j < tempList.size(); j++) {
                Point point2 = tempList.get(j);
                if ((point2.y - point1.y) >= shortestDistance)
                    break;
                double distance = pair.distance(point1, point2);
                if (distance < closestPair.distance) {
                    closestPair.update(point1, point2, distance);
                    shortestDistance = distance;
                }
            }
        }
        return closestPair;
    }

}