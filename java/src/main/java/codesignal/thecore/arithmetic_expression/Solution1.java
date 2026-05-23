package codesignal.thecore.arithmetic_expression;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static boolean solution(int a, int b, int c) {
        if(a + b == c) { return true; }
        if(a - b == c) { return true; }
        if(a * b == c) { return true; }
        if(a / b == c && a % b == 0) { return true; }
        
        return false;
    }
}
