package codesignal.intro.longest_word;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Split on non-word characters, stream max by length.
class Solution2 {
    static String solution(String txt) {
        return Arrays.stream(txt.split("\\W+"))
                     .max((a, b) -> a.length() - b.length())
                     .get();
    }
}
