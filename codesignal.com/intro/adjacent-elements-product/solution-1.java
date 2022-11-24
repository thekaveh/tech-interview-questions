int solution(int[] A) {
    var N = A.length;
    var R = Integer.MIN_VALUE;
    
    for(var i = 1; i < N; i++) {
        var T = A[i - 1] * A[i];
        R = Math.max(R, T);
    }
    
    return R;
}