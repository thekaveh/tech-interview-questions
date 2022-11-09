import java.util.*;

class Program {
    public static int getNthFib(int n) {
        var M = new int[] { 0, 1 };

        if(n == 1 ||n == 2) { return M[n - 1]; }
        
        for(var i = 3; i <= n; i++) {
            var t = M[0] + M[1];
            M[0] = M[1];
            M[1] = t;
        }

        return M[1];
    }
}