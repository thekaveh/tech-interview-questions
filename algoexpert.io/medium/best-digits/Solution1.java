import java.util.*;

class Solution1 {
    public String bestDigits(String number, int numDigits) {
        var S = new LinkedList<Character>();

        for (var digit : number.toCharArray()) {
            while (0 < numDigits && !S.isEmpty() && S.peek() < digit) {
                S.pop();
                numDigits--;
            }

            S.push(digit);
        }

        while (0 < numDigits) {
            S.pop();
            numDigits--;
        }

        var R = new StringBuilder();
        while (!S.isEmpty()) { R.append(S.pop()); }
        R.reverse();
        return R.toString();
    }
}