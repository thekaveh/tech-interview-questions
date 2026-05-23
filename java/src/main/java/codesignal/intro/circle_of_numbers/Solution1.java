package codesignal.intro.circle_of_numbers;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Direct arithmetic modulo n.
class Solution1 {
    static int solution(int N, int firstNumber) {
        return (N / 2 + firstNumber) % N;
    }
}
