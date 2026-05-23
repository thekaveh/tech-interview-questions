package algoexpert.easy.nth_fibonacci;
import java.util.*;

// Approach: Recursive memoization, HashMap.
class Solution2 {
    public static int getNthFib(int n) {
        if(n == 1 || n == 2) { return n - 1; }
        
        var M = new HashMap<Integer, Integer>();
        M.put(1, 0);
        M.put(2, 1);

        return solve(n, M);
    }

    private static int solve(int n, Map<Integer, Integer> M) {
        if(!M.containsKey(n)) {
            M.put(n, solve(n - 2, M) + solve(n - 1, M));
        }

        return M.get(n);
    }
}
