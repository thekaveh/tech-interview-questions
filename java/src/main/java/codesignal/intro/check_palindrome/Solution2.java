package codesignal.intro.check_palindrome;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Compare with reversed string.
class Solution2 {
    static boolean solution(String inputString) {
        return inputString.equals(new StringBuilder(inputString).reverse().toString());
    }
}
