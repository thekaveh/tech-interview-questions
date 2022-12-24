class Solution {
    int solution(int[] A) {
        var ret = 0;
        var N = A.length;
        
        Arrays.sort(A);
        
        for(var i = 1; i < N; i++) {
            if(A[i] - A[i - 1] == 1) { continue; }
            
            ret += A[i] - A[i - 1] - 1;
        }
        
        return ret;
    }
}