import java.util.*;

class Program {
    private static void swap(List<Integer> A, int i, int j) {
        var T = A.get(i);
        A.set(i, A.get(j));
        A.set(j, T);
    }

    public static List<Integer> moveElementToEnd(List<Integer> A, int v) {
        var N = A.size();

        var lo = 0;
        var hi = N - 1;

        while(lo < hi) {
            if(A.get(lo) == v) { swap(A, lo, hi--); }
            else               { lo++; }
        }

        return A;
    }
}