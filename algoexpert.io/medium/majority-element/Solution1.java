import java.util.*;

class Solution1 {
    public int majorityElement(int[] A) {
        var N = A.length;
        var majority = 0;

        for (var bit = 0; bit < 32; bit++) {
            var component = 1 << bit;
            var nComponents = 0;

            for (var a : A) {
                if ((a & component) == 0) {
                    continue;
                }

                nComponents++;
            }

            if (nComponents > N / 2) {
                majority += component;
            }
        }

        return majority;
    }
}