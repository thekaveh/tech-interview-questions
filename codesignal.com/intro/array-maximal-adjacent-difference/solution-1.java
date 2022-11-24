int solution(int[] A) {
    var N = A.length;
    
    var R = Integer.MIN_VALUE;
    
    for(var i = 1; i < N; i++) {
        var D = Math.abs(A[i] - A[i - 1]);
        
        R = Math.max(R, D);
    }
    
    return R;
}