package algoexpert.veryhard.minimum_area_rectangle;
import java.util.*;

// Approach: Point-set lookup: for each diagonal pair check the other two corners.
class Solution1 {
    public int minimumAreaRectangle(int[][] points) {
        var result = Integer.MAX_VALUE;

        var M = new HashSet<String>();
        for (var point : points) {
            M.add(toString(point));
        }

        for (var pointA : points) {
            for (var pointB : points) {
                if (pointA == pointB) {
                    continue;
                }

                if (pointA[0] == pointB[0]) {
                    continue;
                }
                if (pointA[1] == pointB[1]) {
                    continue;
                }

                var pointC = new int[] { pointA[0], pointB[1] };
                var pointD = new int[] { pointB[0], pointA[1] };

                if (!M.contains(toString(pointC))) {
                    continue;
                }
                if (!M.contains(toString(pointD))) {
                    continue;
                }

                result = Math.min(result, Math.abs(pointA[0] - pointB[0]) * Math.abs(pointA[1] - pointB[1]));
            }
        }

        return result != Integer.MAX_VALUE ? result : 0;
    }

    private static String toString(int[] point) {
        return point[0] + ":" + point[1];
    }
}
