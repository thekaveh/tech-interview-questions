package algoexpert.medium.powerset;
import java.util.*;

// Approach: Bitmask with explicit boolean bitmask helper.
class Solution4 {
    public static List<List<Integer>> powerset(List<Integer> A) {
        int N = A.size();
        var R = new ArrayList<List<Integer>>();

        for(var i = 0; i < (1 << N); i++) { R.add(select(A, getBitmask(i, N))); }

        return R;
    }
	
    private static List<Boolean> getBitmask(int k, int n) {
        var bitmask = new ArrayList<Boolean>();
        
        while(k > 0) {
            bitmask.add(0, (k % 2) == 1);
            
            k /= 2;
        }
        
        for(var i = bitmask.size(); i < n; i++) { bitmask.add(0, false); }
        
        return bitmask;
    }

    private static List<Integer> select(List<Integer> A, List<Boolean> bitmask) {
        var R = new ArrayList<Integer>();
        
        for(int i = 0; i < A.size(); i++) {
            if(bitmask.get(i)) { R.add(0, A.get(i)); }
        }
        
        return R;
    }
}
