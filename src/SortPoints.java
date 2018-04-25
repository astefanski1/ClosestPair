import java.util.Comparator;
import java.util.List;

public class SortPoints {

    public void sortByX(List<? extends Point> points) {
        points.sort((Comparator<Point>) (point1, point2) -> {
            if (point1.x < point2.x) return -1;
            if (point1.x > point2.x) return 1;
            return 0;
        });
    }

    public void sortByY(List<? extends Point> points) {
        points.sort((Comparator<Point>) (point1, point2) -> {
            if (point1.y < point2.y) return -1;
            if (point1.y > point2.y) return 1;
            return 0;
        });
    }
}