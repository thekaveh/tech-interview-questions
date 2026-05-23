package codesignal.thecore.array_replace;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Stream map replacing matching elements, collecting to new array.
class Solution2 {
    static int[] solution(int[] A, int fromElem, int toElem) {
        return Arrays.stream(A)
                     .map(a -> a == fromElem ? toElem : a)
                     .toArray();
    }
}
