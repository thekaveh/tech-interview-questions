package algoexpert.medium.powerset;
import java.util.*;

// Approach: Iterative doubling: append new element to all existing subsets.
class Solution3 {
    public static List<List<Integer>> powerset(List<Integer> A) {
        var R = new ArrayList<List<Integer>>();

        R.add(new ArrayList<Integer>());

        for(var a : A) {
            var L = R.size();
            
            for(var i = 0; i < L; i++) {
                var T = new ArrayList<Integer>(R.get(i));
                
                T.add(a);
                
                R.add(T);
            }
        }

        return R;
    }
}
