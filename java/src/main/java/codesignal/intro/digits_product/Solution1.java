package codesignal.intro.digits_product;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Linear scan checking digit product of each candidate.
class Solution1 {
    static int solution(int product) {
        for(var num = 1; num < 65522; num++) {
            if(digitsProductEquals(num, product)) { return num; }
        }

        return -1;
    }

    static boolean digitsProductEquals(int num, int prod) {
        var p = 1;

        while(num > 0) {
            p *= num % 10;

            num /= 10;
        }

        return p == prod;
    }
}
