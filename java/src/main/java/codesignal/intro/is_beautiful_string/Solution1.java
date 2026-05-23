package codesignal.intro.is_beautiful_string;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Frequency array, check non-increasing order.
class Solution1 {
    static boolean solution(String txt) {
        var FREQ = new int[26];

        for(var c : txt.toCharArray()) { FREQ[c - 'a']++; }

        for(var i = 1; i < 26; i++) {
            if(FREQ[i - 1] < FREQ[i]) { return false; }
        }

        return true;
    }
}
