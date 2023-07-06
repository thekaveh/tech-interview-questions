import java.util.*;

class Solution1 {
    public ArrayList<Integer> sortStack(ArrayList<Integer> S) {
        var N = S.size();

        for(var i = 0; i < N; i++) {
            var top = S.remove(N - 1 - i);

            sortWith(S, top);
        }

        return S;
    }

    private static void sortWith(ArrayList<Integer> S, int val) {
        var N = S.size();

        if(N == 0) { S.add(val); return; }

        var top = S.remove(N - 1);

        if(val < top)   { sortWith(S, val); S.add(top); }
        else            { sortWith(S, top); S.add(val); }
    }
}