package codesignal.intro.shape_area;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Closed-form formula: n² + (n-1)².
class Solution2 {
    static int solution(int n) {
        return (n * n) + ((n-1) * (n-1)); 
    }
}
