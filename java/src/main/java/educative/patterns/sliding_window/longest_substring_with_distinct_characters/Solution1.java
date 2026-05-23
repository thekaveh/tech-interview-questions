package educative.patterns.sliding_window.longest_substring_with_distinct_characters;
import java.util.*;

// Approach: Variable-size sliding window with a map storing each character's last-seen index; jump left pointer on repeat.
class Solution1 {
    public static int findLength(String txt) {
        int N = txt.length(), lo = 0, L = 0;

        Map<Character, Integer> M = new HashMap<>();

        for (int hi = 0; hi < N; hi++) {
            char hiC = txt.charAt(hi);

            if (M.containsKey(hiC)) {
                lo = Math.max(lo, M.get(hiC) + 1);
            }

            M.put(hiC, hi);

            L = Math.max(L, hi - lo + 1);
        }

        return L;
    }
}
