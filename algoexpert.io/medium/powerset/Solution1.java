import java.util.*;

class Solution1 {
    public static List<List<Integer>> powerset(List<Integer> X) {
        var nX = X.size();
        var nP = 1 << nX;

        var P = new ArrayList<List<Integer>>();

        for(var indP = 0; indP < nP; indP++) {
            var S = new ArrayList<Integer>();

            for(var indX = 0; indX < nX; indX++) {
                if ((indP & (1 << indX)) == 0) { continue; }

                S.add(X.get(indX));
            }

            P.add(S);
        }

        return P;
    }
}