import java.util.*;

class Solution1 {
    public int reversePolishNotation(String[] tokens) {
        var S = new Stack<String>();

        for (var token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                var b = Integer.valueOf(S.pop());
                var a = Integer.valueOf(S.pop());

                if (token.equals("+")) {
                    S.push(String.valueOf(a + b));
                } else if (token.equals("-")) {
                    S.push(String.valueOf(a - b));
                } else if (token.equals("*")) {
                    S.push(String.valueOf(a * b));
                } else if (token.equals("/")) {
                    S.push(String.valueOf(a / b));
                }
            } else {
                S.push(token);
            }
        }

        return Integer.valueOf(S.pop());
    }
}