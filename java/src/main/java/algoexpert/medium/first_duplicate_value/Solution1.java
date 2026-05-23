package algoexpert.medium.first_duplicate_value;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public int firstDuplicateValue(int[] A) {
        var M = new HashSet<Integer>();

        for(var a : A) {
            if(M.contains(a)) { return a; }

            M.add(a);
        }

        return -1;
    }
}
