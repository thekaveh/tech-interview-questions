import java.util.*;

class Solution2 {
    public int majorityElement(int[] A) {
        var n = 0;
        var candidate = A[0];

        for (var a : A) {
            if (n == 0) {
                candidate = a;
            }

            if (a == candidate) {
                n++;
            } else {
                n--;
            }
        }

        return candidate;
    }
}