import java.util.*;

class Program {
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

    public ArrayList<String> phoneNumberMnemonics(String P) {
        var N = P.length();
        var Q = new LinkedList<String>();

        Q.offer(P);

        for(var i = 0; i < N; i++) {
            var p = P.charAt(i);

            if(Character.isLetter(p) || p == '0' || p == '1') { continue; }

            var L = Q.size();

            for(var j = 0; j < L; j++) {
                var T = Q.poll();

                for(var mnemonic : MNEMONICS.get(p)) {
                    var U = T.toCharArray();

                    U[i] = mnemonic;

                    Q.offer(String.valueOf(U));
                }
            }
        }

        return new ArrayList<>(Q);
    }
}