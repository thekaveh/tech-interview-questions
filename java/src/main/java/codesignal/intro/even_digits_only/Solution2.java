package codesignal.intro.even_digits_only;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Convert to string and match regex of even digits.
class Solution2 {
    static boolean solution(int n) {
        return Integer.toString(n).matches("(0|2|4|6|8)*");
    }
}
