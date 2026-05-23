package codesignal.thecore.extra_number;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int a, int b, int c) {
        if(a == b) { return c; }
        if(a == c) { return b; }
        if(b == c) { return a; }
        
        return -1;
    }
}
