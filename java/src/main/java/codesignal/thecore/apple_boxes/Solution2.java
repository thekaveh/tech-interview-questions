package codesignal.thecore.apple_boxes;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int k) {
        return (int) Math.pow(-1, k) * k * (k + 1) / 2;
    }   
}
