import java.util.stream.IntStream;

class Solution {
    int solution(int a, int b, int n) {
        return IntStream.range(0, n)
                        .map(i -> (a + i) * (b + i))
                        .sum();
    }
}