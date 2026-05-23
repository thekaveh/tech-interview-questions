package codesignal.thecore.circle_of_numbers;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Modular arithmetic: (firstNumber + n/2) mod n.
class Solution1 {
    static int solution(int n, int firstNumber) {
        return (firstNumber + n / 2) % n;
    }
}
