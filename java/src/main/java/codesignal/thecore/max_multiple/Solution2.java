package codesignal.thecore.max_multiple;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Direct formula: floor(bound / divisor) * divisor.
class Solution2 {
    static int solution(int divisor, int bound) {
        return (bound / divisor) * divisor;
    }
}
