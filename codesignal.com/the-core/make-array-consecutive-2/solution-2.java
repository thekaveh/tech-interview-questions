class Solution {
    int solution(int[] A) {
        var N = A.length;

        Arrays.sort(A);

        return A[N - 1] - A[0] + 1 - N;
    }
}