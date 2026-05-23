package codesignal.intro.is_digit;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Offset arithmetic against '0'.
class Solution1 {
    static boolean solution(char symbol) {
        var offset = symbol - '0';
        
        return 0 <= offset && offset <= 9;
    }
}
