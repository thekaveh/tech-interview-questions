package codesignal.intro.alphabetic_shift;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Stream chars with map.
class Solution2 {
    static String solution(String txt) {
        return new String(
            txt.chars()
               .map(c -> (c - 'a' + 1) % 26 + 'a')
               .toArray()
            , 0
            , txt.length()
        );
    }
}
