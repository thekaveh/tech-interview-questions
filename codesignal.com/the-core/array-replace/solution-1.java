class Solution {
    int[] solution(int[] A, int fromElem, int toElem) {
        var N = A.length;
        
        for(var i = 0; i < N; i++) {
            if(A[i] != fromElem) { continue; }
            
            A[i] = toElem;
        }
        
        return A;
    }
}