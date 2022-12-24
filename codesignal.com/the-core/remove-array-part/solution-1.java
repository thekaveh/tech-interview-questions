class Solution {
    int[] solution(int[] A, int lo, int hi) {
        var M = A.length;
        var N = M - (hi - lo + 1);
        
        var idx = 0;
        var R = new int[N];
        
        for(var i = 0; i < lo; i++)     { R[idx++] = A[i]; }
        for(var i = hi + 1; i < M; i++) { R[idx++] = A[i]; }
        
        return R;
    }
}