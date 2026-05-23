package algoexpert.veryhard.rectangle_mania;
import java.util.*;

// Approach: Point-set lookup: for each ordered pair of non-collinear points check opposite corners.
class Solution1 {
    public static int rectangleMania(List<Integer[]> coords) {
        var M = new HashSet<String>();
        var points = Point.fromCoords(coords);

        var count = 0;

        for (var point : points) {
            M.add(point.toString());
        }

        for (var p1 : points) {
            for (var p2 : points) {
                if (p1 == p2) {
                    continue;
                }
                if (p1.x == p2.x) {
                    continue;
                }
                if (p1.y == p2.y) {
                    continue;
                }

                var p3 = new Point(p1.x, p2.y);
                if (!M.contains(p3.toString())) {
                    continue;
                }

                var p4 = new Point(p2.x, p1.y);
                if (!M.contains(p4.toString())) {
                    continue;
                }

                count++;
            }
        }

        return count / 4;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + ":" + this.y;
        }

        public static Point[] fromCoords(List<Integer[]> coords) {
            var n = coords.size();
            var points = new Point[n];

            for (var at = 0; at < n; at++) {
                points[at] = new Point(coords.get(at)[0], coords.get(at)[1]);
            }

            return points;
        }
    }
}
