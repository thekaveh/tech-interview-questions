import java.util.*;

class Program {
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

    public ArrayList<String> phoneNumberMnemonics(String P) {
        var N = P.length();
        var Q = new LinkedList<String>();

        Q.offer(P);

        for(var i = 0; i < N; i++) {
            var p = P.charAt(i);

            if(p == '0' || p == '1') { continue; }

            var L = Q.size();

            for(var j = 0; j < L; j++) {
                var T = Q.poll();

                for(var mnemonic : MNEMONICS.get(p).toCharArray()) {
                    var U = new StringBuilder(T);

                    U.setCharAt(i, mnemonic);

                    Q.offer(U.toString());
                }
            }
        }

        return new ArrayList<>(Q);
    }
}