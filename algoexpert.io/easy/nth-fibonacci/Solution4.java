import java.util.*;

class Solution4 {
    public static int getNthFib(int n) {
        if(n == 1 || n == 2) { return n - 1; }
        
        var M = new int[] { 0, 1 };
        
        for(var i = 3; i <= n; i++) {
            var t = M[0] + M[1];
            M[0] = M[1];
            M[1] = t;
        }

        return M[1];
    }
}