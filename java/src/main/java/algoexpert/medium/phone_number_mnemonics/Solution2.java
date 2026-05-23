package algoexpert.medium.phone_number_mnemonics;
import java.util.*;

// Approach: Iterative BFS expansion with StringBuilder substitution.
class Solution2 {
    static final Map<Character, String> MNEMONICS = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
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

                for(var mnemonic : MNEMONICS.get(c).toCharArray()) {
                    var w = new StringBuilder(v);

                    w.setCharAt(i, mnemonic);

                    Q.offer(w.toString());
                }
            }
        }

        return new ArrayList<>(Q);
    }
}
