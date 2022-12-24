import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    int[] solution(int[] A, int fromElem, int toElem) {
        return Arrays.stream(A)
                     .map(a -> a == fromElem ? toElem : a)
                     .toArray();
    }
}