package algoexpert.medium.powerset;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static List<List<Integer>> powerset(List<Integer> A) {
        var nA = A.size();
        var nP = 1 << nA;

        var P = new ArrayList<List<Integer>>();

        for(var idxP = 0; idxP < nP; idxP++) {
            var S = new ArrayList<Integer>();

            for(var idxA = 0; idxA < nA; idxA++) {
                if ((idxP & (1 << idxA)) == 0) { continue; }

                S.add(A.get(idxA));
            }

            P.add(S);
        }

        return P;
    }
}
