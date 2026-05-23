package codesignal.intro.longest_word;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static String solution(String txt) {
        return Arrays.stream(txt.split("\\W+"))
                     .max((a, b) -> a.length() - b.length())
                     .get();
    }
}
