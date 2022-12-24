class Solution {
    int[] solution(int[] A, int[] B) {
        var M = A.length;
        var N = B.length;
        
        var idx = 0;
        var R = new int[M + N];
        
        for(var a : A) { R[idx++] = a; }
        for(var b : B) { R[idx++] = b; }
        
        return R;
    } 
}