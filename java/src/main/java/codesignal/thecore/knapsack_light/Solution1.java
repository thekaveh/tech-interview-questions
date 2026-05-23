package codesignal.thecore.knapsack_light;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Greedy: take the higher-value item first if it fits, then attempt the second.
class Solution1 {
    static int solution(int v1, int w1, int v2, int w2, int wMax) {
        var v = 0;
        
        if(v1 < v2 && w2 <= wMax) {
            v += v2; wMax -= w2;
            
            if(w1 <= wMax) { v += v1; }
        }
        else if(w1 <= wMax){
            v += v1; wMax -= w1;
            
            if(w2 <= wMax) { v+= v2; }
        }
        
        return v;
    }
}
