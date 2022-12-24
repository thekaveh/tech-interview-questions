class Solution {
    int[] solution(int[] A, int[] B) {
        var M = A.length;
        var N = B.length;
        
        var R = new int[M + N];
        
        System.arraycopy(A, 0, R, 0, M);
        System.arraycopy(B, 0, R, M, N);
        
        return R;
    } 
}