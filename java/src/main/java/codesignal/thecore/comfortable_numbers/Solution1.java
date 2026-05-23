package codesignal.thecore.comfortable_numbers;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Brute-force pair enumeration with extracted digit-sum helper.
class Solution1 {
    static int solution(int l, int r) {
        var count = 0;
        
        for(var i = l; i < r; i++) {
            for(var j = i + 1; j <= r; j++) {
                if(!comfortableWith(i, j) || !comfortableWith(j, i)) { continue; }
                
                count++;
            }
        }
        
        return count;
    }
    
    static boolean comfortableWith(int a , int b) {
        if(a == b) { return false; }
        
        if(b < a - sumOfDigits(a) || a + sumOfDigits(a) < b) { return false; }
        
        return true;
    }
    
    static int sumOfDigits(int num) {
        var ret = 0;
        
        while(num > 0) {
            ret += num % 10;
            
            num /= 10;
        }
        
        return ret;
    }  
}
