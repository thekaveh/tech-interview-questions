import java.util.*;

class Program {
    public static int getNthFib(int n) {
        if(n == 1 || n == 2) { return n - 1; }

        var M = new Integer[n + 1];
        M[1] = 0;
        M[2] = 1;

        return getNthFib(n, M);
    }

    private static int getNthFib(int n, Integer[] M) {
        if(M[n] == null) {
            M[n] = getNthFib(n - 2, M) + getNthFib(n - 1, M);
        }

        return M[n];
    }
}