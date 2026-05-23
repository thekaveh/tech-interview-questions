package codesignal.thecore.metro_card;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int[] solution(int lastNumberOfDays) {
        if(lastNumberOfDays == 31)
           return new int[]{28,30,31};
           
       return new int[]{31};
    }
}
