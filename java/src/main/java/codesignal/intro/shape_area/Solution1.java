package codesignal.intro.shape_area;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int n) {
        if(n == 1) { return 1; }
        
        return solution(n - 1) + 4 * (n - 1);
    }
}
