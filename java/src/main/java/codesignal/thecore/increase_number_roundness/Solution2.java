package codesignal.thecore.increase_number_roundness;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Regex match for an interior zero followed by any non-zero suffix.
class Solution2 {
    static boolean solution(int n) {
        return (n + "").matches(".*0[^0]+0*");
    }
}
