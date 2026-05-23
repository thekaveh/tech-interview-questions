package codesignal.thecore.pages_numbering_with_ink;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Simulate printing pages, deducting digit count until ink runs out.
class Solution1 {
    static int solution(int current, int remainingDigits) {
        while(numOfDigits(current) <= remainingDigits) {
            remainingDigits -= numOfDigits(current);
            current++;
        }
        
        return current - 1;
    }
    
    static int numOfDigits(int num) {
        return Integer.toString(num).length();
    }
}
