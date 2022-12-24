import java.util.stream.IntStream;

class Solution {
    int[] solution(int[] A, int lo, int hi) {
        var N = A.length;

        return IntStream.range(0, N)
                        .filter(idx -> idx < lo || idx > hi)
                        .map(idx -> A[idx])
                        .toArray();
    }
}