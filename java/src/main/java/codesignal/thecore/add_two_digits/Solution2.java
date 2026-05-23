package codesignal.thecore.add_two_digits;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Direct arithmetic: tens digit plus units digit.
class Solution2 {
    static int solution(int n) {
        return n / 10 + n % 10;
    }
}
