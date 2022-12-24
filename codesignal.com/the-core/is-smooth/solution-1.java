class Solution {
    boolean solution(int[] A) {
        var N = A.length;
        
        if(A[0] != A[N - 1]) { return false; }
        
        if(N % 2 == 1) {
            return A[0] == A[(N - 1) / 2];
        }
        
        return A[0] == (A[N / 2 - 1] + A[N / 2]);
    }
}