package educative.patterns.sliding_window.longest_substring_with_same_letters_after_replacement;
import java.util.*;

// Approach: Sliding window + character count; shrink when (window size − max frequency) exceeds k.
class Solution1 {
    public static int findLength(String txt, int k) {
        int N = txt.length();
        int lo = 0;
        int max = 0;
        Map<Character, Integer> M = new HashMap<>();
        int L = 0;

        for (int hi = 0; hi < N; hi++) {
            char hiC = txt.charAt(hi);

            M.put(hiC, M.getOrDefault(hiC, 0) + 1);
            max = Math.max(max, M.get(hiC));

            if (k < hi - lo + 1 - max) {
                char loC = txt.charAt(lo++);

                M.put(loC, M.get(loC) - 1);
            }

            L = Math.max(L, hi - lo + 1);
        }

        return L;
    }
}
