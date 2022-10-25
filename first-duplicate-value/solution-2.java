import java.util.*;

class Program {
    public int firstDuplicateValue(int[] A) {
        for(var a : A) {
            if(isVisited(a, A)) { return Math.abs(a); }

            visit(a, A);
        }

        return -1;
    }

    private static boolean isVisited(int a, int[] A) {
        return A[Math.abs(a) - 1] < 0;
    }

    private static void visit(int a, int[] A) {
        A[Math.abs(a) - 1] *= -1;
    }
}