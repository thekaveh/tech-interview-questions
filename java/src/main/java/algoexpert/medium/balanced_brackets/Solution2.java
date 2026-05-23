package algoexpert.medium.balanced_brackets;
import java.util.*;

// Approach: Stack with String index lookup.
class Solution2 {
	private static final String OPENING_BRACKETS = "([{";
	private static final String CLOSING_BRACKETS = ")]}";
	
    public static boolean balancedBrackets(String txt) {
        var S = new Stack<Character>();
        
        for(var c : txt.toCharArray()) {
            if      (OPENING_BRACKETS.indexOf(c) != -1) { S.push(c); }
            else if	(CLOSING_BRACKETS.indexOf(c) != -1) {
                if(S.isEmpty()) { return false; }
                
                if(OPENING_BRACKETS.indexOf(S.peek()) != CLOSING_BRACKETS.indexOf(c)) { return false; }
                
                S.pop();
            }
        }
        
        return S.isEmpty();
    }
}
