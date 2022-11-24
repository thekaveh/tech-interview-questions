int solution(int[] A) {
    var N = A.length;
    var R = 0;
    
    Arrays.sort(A);
    
    for(var i = 1; i < N; i++) {
        if(A[i] - A[i - 1] == 1) { continue; }
        
        R += A[i] - A[i - 1] - 1;
    }
    
    return R;
}