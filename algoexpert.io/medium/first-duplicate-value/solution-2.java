import java.util.*;

class Program {
    public int firstDuplicateValue(int[] A) {
        for(var a : A) {
            if(isMarked(a, A)) { return unmarked(a); }

            mark(a, A);
        }

        return -1;
    }

    private static boolean isMarked(int a, int[] A) {
        return A[Math.abs(a) - 1] < 0;
    }

    private static void mark(int a, int[] A) {
        A[Math.abs(a) - 1] *= -1;
    }

    private static int unmarked(int a) {
        return Math.abs(a);
    }
}