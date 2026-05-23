package algoexpert.easy.product_sum;
import java.util.*;

// Approach: TODO.
class Solution1 {
    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.
    public static int productSum(List<Object> A) {
        return solve(A, 1);
    }

    private static int solve(List<Object> A, int coefficient) {
        var S = 0;

        for(var a : A) {
            if      (a instanceof Integer)      { S += (Integer) a; }
            else if (a instanceof ArrayList)    { S += solve((List<Object>) a, coefficient + 1); }
        }

        return coefficient * S;
    }
}
