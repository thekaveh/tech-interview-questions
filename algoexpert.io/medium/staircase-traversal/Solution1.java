import java.util.*;

class Solution1 {
    // T: O(S ^ H) - S: O(H)
    public int staircaseTraversal(int H, int S) {
        if(H <= 1) { return 1; }

        var R = 0;
        
        for(var s = 1; s <= Math.min(S, H); s++) {
            R += staircaseTraversal(H - s, S);
        }

        return R;
    }
}