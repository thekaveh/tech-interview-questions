package algoexpert.medium.sort_stack;
import java.util.*;

// Approach: Recursive: pop top, sort remainder, insert at correct position.
class Solution2 {
    public ArrayList<Integer> sortStack(ArrayList<Integer> S) {
        var N = S.size();

        if(N == 0) { return S; }

        var top = S.remove(N - 1);

        sortStack(S);

        insertInSortedOrder(S, top);

        return S;
    }

    private static void insertInSortedOrder(ArrayList<Integer> S, int val) {
        var N = S.size();

        if(N == 0 || S.get(N - 1) <= val) { S.add(val); return; }

        var top = S.remove(N - 1);

        insertInSortedOrder(S, val);

        S.add(top);
    }
}
