package codesignal.thecore.late_ride;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Compute hours and minutes, then sum digits of each via a while loop.
class Solution1 {
    static int solution(int n) {
        var h = n / 60;
        var m = n % 60;
        
        var s = 0;
        
        while(h > 0) { s += h % 10; h /= 10; }
        while(m > 0) { s += m % 10; m /= 10; }
        
        return s;
    }
}
