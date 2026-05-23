package algoexpert.medium.phone_number_mnemonics;
import java.util.*;

// Approach: Iterative BFS expansion with char-array substitution.
class Solution1 {
    private static final Map<Character, char[]> MNEMONICS = new HashMap<>() {{
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};

    public ArrayList<String> phoneNumberMnemonics(String number) {
        var N = number.length();
        var Q = new LinkedList<String>();

        Q.offer(number);

        for(var i = 0; i < N; i++) {
            var c = number.charAt(i);

            if(c == '0' || c == '1') { continue; }

            var L = Q.size();

            for(var j = 0; j < L; j++) {
                var v = Q.poll();

                for(var mnemonic : MNEMONICS.get(c)) {
                    var w = v.toCharArray();

                    w[i] = mnemonic;

                    Q.offer(String.valueOf(w));
                }
            }
        }

        return new ArrayList<>(Q);
    }
}
