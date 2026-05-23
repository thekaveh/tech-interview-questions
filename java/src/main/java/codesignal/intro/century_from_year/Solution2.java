package codesignal.intro.century_from_year;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Direct arithmetic via (year - 1) / 100 + 1.
class Solution2 {
    static int solution(int year) {
        return 1 + (year - 1) / 100;
    }
}
