package algoexpert.medium.balanced_brackets;
import java.util.*;

// Approach: TODO.
class Solution1 {
    private static final List<Character> OPENING_BRACKETS = Arrays.asList('(', '[', '{');
    private static final List<Character> CLOSING_BRACKETS = Arrays.asList(')', ']', '}');

    public static boolean balancedBrackets(String txt) {
        var S = new Stack<Character>();

        for(var token : txt.toCharArray()) {
            if      (OPENING_BRACKETS.contains(token)) { S.push(token); }
            else if (CLOSING_BRACKETS.contains(token)) {
                if(S.isEmpty()) { return false; }

                if(!S.peek().equals(OPENING_BRACKETS.get(CLOSING_BRACKETS.indexOf(token)))) { return false; }

                S.pop();
            }
        }

        return S.isEmpty();
    }
}
