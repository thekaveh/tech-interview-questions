package codesignal.thecore.is_infinite_loop;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Check: loop is infinite if a > b or (b − a) is odd.
class Solution1 {
    static boolean solution(int a, int b) {
        return a > b || (b - a) % 2 == 1;
    }
}
