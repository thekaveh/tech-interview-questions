package codesignal.thecore.candles;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Simulation loop tracking stubs and accumulating total burned.
class Solution1 {
    static int solution(int candlesNumber, int makeNew) {
        var ret = 0;
        var left = 0;
        
        while(candlesNumber > 0) {
            ret += candlesNumber;   
            left += candlesNumber;
            
            candlesNumber = left / makeNew;
            left = left % makeNew;
        }
        
        return ret;
    }
}
