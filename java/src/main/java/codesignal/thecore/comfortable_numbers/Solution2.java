package codesignal.thecore.comfortable_numbers;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Brute-force pair enumeration using stream-based digit-sum computation.
class Solution2 {
    static int solution(int l, int r) {
        int total = 0;

        for (int i = l; i < r; i++) {
            for (int j = i + 1; j <= r; j++) {
                int sumi = String.valueOf(i).chars().map(c -> Character.getNumericValue(c)).sum();
                int sumj = String.valueOf(j).chars().map(c -> Character.getNumericValue(c)).sum();

                if ((i - sumi) <= j && j <= (i + sumi) && (j - sumj) <= i && i <= (j + sumj)) {
                    total++;
                }
            }
        }

        return total;
    }
}
