package codesignal.thecore.late_ride;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int n) {
        var hours = n / 60;
        var minutes = n % 60;

        return hours / 10 + hours % 10 + minutes / 10 + minutes % 10;
    }
}
