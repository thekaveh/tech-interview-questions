package codesignal.intro.deposit_profit;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Iterative simulation year by year.
class Solution1 {
    static int solution(int deposit, int rate, int threshold) {
        var years = 0;
        var current = (double)deposit;
        
        while(current < threshold) {
            current *=  1 + (rate / 100.0);
            years++;
        }
        
        return years;
    }
}
