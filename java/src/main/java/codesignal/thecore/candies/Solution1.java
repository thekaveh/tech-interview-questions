package codesignal.thecore.candies;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Subtract remainder: m − (m mod n).
class Solution1 {
    static int solution(int n, int m) {
        return m - (m % n);
    }
}
