package algoexpert.medium.move_element_to_end;
import java.util.*;

// Approach: TODO.
class Solution1 {
    private static void swap(List<Integer> A, int i, int j) {
        var T = A.get(i);
        A.set(i, A.get(j));
        A.set(j, T);
    }

    public static List<Integer> moveElementToEnd(List<Integer> A, int v) {
        var N = A.size();

        var at = 0;
        var hi = N - 1;

        while(at <= hi) {
            if(A.get(at) == v) { swap(A, at, hi--); }
            else               { at++; }
        }

        return A;
    }
}
