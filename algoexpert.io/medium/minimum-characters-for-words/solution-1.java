import java.util.*;

class Program {
    public char[] minimumCharactersForWords(String[] W) {
        var maxFREQ = new HashMap<Character, Integer>();

        for(var w : W) {
            var FREQ = new HashMap<Character, Integer>();

            for(var c : w.toCharArray()) {
                FREQ.put(c, FREQ.getOrDefault(c, 0) + 1);

                maxFREQ.put(c, Math.max(maxFREQ.getOrDefault(c, 0), FREQ.get(c)));
            }
        }

        var N = 0;
        for(var val : maxFREQ.values()) { N += val; }
        var R = new char[N];

        var k = 0;
        for(var entry : maxFREQ.entrySet()) {
            for(var i = 0; i < entry.getValue(); i++) { R[k++] = entry.getKey(); }
        }

        return R;
    }
}