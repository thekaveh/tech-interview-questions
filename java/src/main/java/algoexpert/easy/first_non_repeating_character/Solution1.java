package algoexpert.easy.first_non_repeating_character;
import java.util.*;

// Approach: Frequency map, linear scan.
class Solution1 {

    public int firstNonRepeatingCharacter(String txt) {
        var N = txt.length();
        var FREQ = new HashMap<Character, Integer>();

        for(var c : txt.toCharArray()) {
            FREQ.put(c, FREQ.getOrDefault(c, 0) + 1);
        }

        for(var i = 0; i < N; i++) {
            var c = txt.charAt(i);

            if(FREQ.get(c) == 1) { return i; }
        }

        return -1;
    }
}
