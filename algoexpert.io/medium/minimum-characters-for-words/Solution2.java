import java.util.*;

class Solution2 {
    public char[] minimumCharactersForWords(String[] words) {
        var FREQ = new HashMap<Character, Integer>();

        for(var word : words) {
            var freq = new HashMap<Character, Integer>();

            for(var c : word.toCharArray()) { freq.put(c, freq.getOrDefault(c, 0) + 1); }

            for(var entry : freq.entrySet()) {
                var key = entry.getKey();
                var val = entry.getValue();

                FREQ.put(key, Math.max(FREQ.getOrDefault(key, 0), val));
            }
        }

        var N = 0;
        for(var val : FREQ.values()) { N += val; }

        var k = 0;
        var R = new char[N];
        for(var entry : FREQ.entrySet()) {
            for(var i = 0; i < entry.getValue(); i++) { R[k++] = entry.getKey(); }
        }

        return R;
    }
}