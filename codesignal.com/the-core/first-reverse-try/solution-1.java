class Solution {
    int[] solution(int[] A) {
        var N = A.length;
        
        if(N == 0) { return A; }
        
        swap(A, 0, N - 1);
        
        return A;
    }
    
    void swap(int[] A, int i, int j) {
        var t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}