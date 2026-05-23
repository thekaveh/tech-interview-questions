package codesignal.intro.deposit_profit;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int deposit, int rate, int threshold) {
        return (int) Math.ceil(Math.log((double) threshold / deposit) / Math.log(1 + (rate / 100.0)));
    }
}
