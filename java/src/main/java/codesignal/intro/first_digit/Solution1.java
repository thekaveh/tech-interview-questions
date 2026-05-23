package codesignal.intro.first_digit;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Linear scan with Character.isDigit.
class Solution1 {
    static char solution(String txt) {
        for(var c : txt.toCharArray()) {
            if(!Character.isDigit(c)) { continue; }

            return c;
        }

        return '\0';
    }
}
