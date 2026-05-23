package codesignal.thecore.least_factorial;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int n) {
        var ret = 1;
        
        for(var i = 2; ret < n; i++) { ret *= i; }
        
        return ret;
    } 
}
